package business.model.department;

public class Department{
    private int departmentId;
    private String departmentName;
    private String description;
    private boolean status;

    public Department() {
    }

    public Department(int departmentId, String departmentName, boolean status, String description) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.status = status;
        this.description = description;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputDepartment(String name, String des) {
        setDepartmentName(name);
        setDescription(des);
        setStatus(true);
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-3d | Tên: %-25s | Mô tả: %-40s | Trạng thái: %s",
                departmentId,
                departmentName,
                description,
                status ? "Hoạt động" : "Không hoạt động"
        );
    }

}
