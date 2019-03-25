cola(function (model) {
	model.set({
		username_: $.cookie("_account"),
		password_: $.cookie("_password"),
		remember_me: $.cookie("_rememberMe"),
		time: new Date().getTime()
	});
	$.removeCookie("_account");
	$.removeCookie("_password");
	$.removeCookie("_rememberMe");
	model.describe({
		username_: {
			validators: {$type: "required", message: ""}
		},
		password_: {
			validators: {$type: "required", message: ""}
		}
	});
	model.action({
		refreshImage: function () {
			model.set("time", new Date().getTime());
		},
		sendTempMessage: function (self, arg) {

			if (!model.get("username_")) {
				cola.widget("formLogin").setMessages([{
					type: "error",
					text: "用户名不能为空!"
				}]);
				return;
			}

			self.get$Dom().addClass("loading");

			$.post("./mail.sendTempPassword", {username: model.get("username_")}).done(function (result) {
				self.get$Dom().removeClass("loading");
				if (result.status) {

					if (result.password) {
						cola.widget("formLogin").setMessages([{
							type: "error",
							text: "验证模式为" + (result.validationMode == "email" ? "邮件" : "短信") + ",模拟获得的秘钥为:" + result.password
						}]);
					} else {
						cola.widget("formLogin").setMessages([{
							type: "error",
							text: result.message
						}]);
					}
				} else {
					cola.widget("formLogin").setMessages([{
						type: "error",
						text: result.message
					}]);
				}
			}).fail(function () {
				self.get$Dom().removeClass("loading");
			});
		}
	});
	model.action({
		login: function (self, arg) {
			var data = model.get();

			function setError(message, option) {
				cola.widget("formLogin").setMessages([{
					type: "error",
					text: message || "用户名或密码有误!"
				}]);
				model.set("time", new Date().getTime());
				self.removeClass("loading");

				if (option) {

					var userLoginCount = parseInt(option["user_login_count"] || 0);
					if (userLoginCount >= 2) {
						var count = 5 - userLoginCount;
						self.set("caption", count > 0 ? "登录 (还有" + count + "次机会!)" : "您的账户已被锁定!")
					} else {
						self.set("caption", "登录")
					}
				}
				$("#loginDialog").transition("shake mild");
			}

			if (data.validate()) {
				self.addClass("loading");
				$.post("security_check_?viewType=html", data).done(function (result) {
					if (result.status === "success") {
						var url = result.url;
						window.location = url.substr(1, url.length);
						return;
					}
					setError("", result);
				}).fail(function () {
					$.get("controller/rbac/login/getFailureInfo").done(function (result) {
						var message = "用户名或密码有误!";
						if (result && result.message) {
							message = result.message;
						}
						if (result && result["user_status"] == "Locked") {
							message = "您的账户已被锁定!"
						}

						setError(message, result);

					}).fail(function () {
						setError("请确认用户名,密码,秘钥,验证码!");
					});
				});
			} else {
				$("#loginDialog").transition("shake mild");
			}
		}
	})

	setTimeout(function () {
		$("#loginDialog").transition("fade down", 500);
	}, 200);
	//结束装载进度条
	$(NProgress.done);

});
