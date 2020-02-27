package rest;

class Employee {

    private int employeeId;
    private String firstName, lastName, email, phone;

    public Employee(int employeeId, String firstName, String lastName, String email, String phone) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "----------------" +
                "employeeId:  " + employeeId +
                "\nfirstName:  " + firstName +
                "\nlastName:  " + lastName +
                "\nemail:  " + email +
                "\nphone:  " + phone +
                "----------------";
    }
}