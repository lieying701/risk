cola(function(model){
    model.action({
        tabClick: function(id) {//subview懒加载
            cola.widget(id).loadIfNecessary();
        },
    })
})