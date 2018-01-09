package com.github.florent37.materialviewpager.sample.vo;

public class Staff {
    private int staff_code;
    private String staff_name;
    private String staff_department;
    private String staff_password;
    private String staff_tel;
    private String staff_email;
    // 직원코드가 직원 아이디가 되어야 하지 않을까?

    public Staff() {
        // TODO Auto-generated constructor stub
    }

    public int getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(int staff_code) {
        this.staff_code = staff_code;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_department() {
        return staff_department;
    }

    public void setStaff_department(String staff_department) {
        this.staff_department = staff_department;
    }
    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    public String getStaff_tel() {
        return staff_tel;
    }

    public void setStaff_tel(String staff_tel) {
        this.staff_tel = staff_tel;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    @Override
    public String toString() {
        return "Staff [staff_code=" + staff_code + ", staff_name=" + staff_name + ", staff_department="
                + staff_department + ", staff_password=" + staff_password + ", staff_tel=" + staff_tel
                + ", staff_email=" + staff_email + "]";
    }


}
