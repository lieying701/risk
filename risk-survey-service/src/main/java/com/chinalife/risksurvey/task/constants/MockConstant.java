package com.chinalife.risksurvey.task.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 模拟我的任务，数据常量
 */
public class MockConstant {

    /**
     * 获取当前录单员
     * 
     * @return MockUser
     */
    public static MockUser getCurrentRecorder() {

        List<MockUser> mockUserList = initMockUser();

        int r = new Random().nextInt(mockUserList.size());

        return mockUserList.get(r);
    }

    /**
     * 查询可分配的人
     * 
     * @return List<MockUser>
     */
    public static List<MockUser> findToAssignUser() {

        return initMockUser();
    }

    /**
     * 查训可提交的人
     * 
     * @return List<MockUser>
     */
    public static List<MockUser> findAssignUserTo() {

        return initMockUser();
    }

    /**
     * 查询当前用户
     * 
     * @return MockUser
     */
    public static MockUser findCurrentUser() {
        List<MockUser> mockUserList = initMockUser();

        int r = new Random().nextInt(mockUserList.size());

        return mockUserList.get(r);
    }

    /**
     * 
     *
     */
    public static class MockUser {

        // 用户代码
        /** userCode */
        private String userCode;
        // 用户名称
        /** userName */
        private String userName;
        // 机构代码
        /** structId */
        private String structId;
        // 机构名称
        /** structName */
        private String structName;
        // 级别
        /** grade */
        private String grade;// 1A 2A 3A 1B 2B 3B
        // 用户所属部门
        /** dept */
        private String dept;
        // 产品代码
        /** productCode */
        private String productCode;
        // 产品名称
        /** productName */
        private String productName;

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getStructId() {
            return structId;
        }

        public void setStructId(String structId) {
            this.structId = structId;
        }

        public String getStructName() {
            return structName;
        }

        public void setStructName(String structName) {
            this.structName = structName;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        @Override
        public String toString() {
            return "MockConstant:\n[" + "用户代码:" + userCode + ",用户名称:" + userName + "\n机构代码:" + structId + ",机构名称:"
                    + structName + "\n级别:" + grade + ",用户所在部门:" + dept + "\n产品代码:" + productCode + ",产品名称:"
                    + productName + "]";
        }

    }

    /**
     * // 初始化MockUser数据
     * 
     * @return List<MockUser>
     */
    private static List<MockUser> initMockUser() {

        List<MockUser> list = new ArrayList<MockUser>();

        for (int i = 1; i <= 9; i++) {
            MockUser mockUser = new MockUser();

            if (i <= 3) {
                mockUser.setGrade(i + "A");
            } else if (i <= 6) {
                mockUser.setGrade((i - 3) + "B");
            } else {
                mockUser.setGrade((i - 6) + "C");
            }
            mockUser.setDept("部门" + i);
            mockUser.setStructId("1100000" + i);
            mockUser.setStructName("机构" + i);
            mockUser.setUserCode("用户代码" + i);
            mockUser.setUserName("用户" + i);
            mockUser.setProductCode("0401000" + i);
            mockUser.setProductName("产品" + i);
            list.add(mockUser);
        }

        return list;
    }

}
