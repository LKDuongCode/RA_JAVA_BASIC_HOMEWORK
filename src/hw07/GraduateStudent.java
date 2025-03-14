package hw07;

public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);

        if (researchTopic == null || researchTopic.trim().isEmpty()) {
            throw new IllegalArgumentException("Đề tài nghiên cứu không được để trống!");
        }
        if (supervisorName == null || supervisorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên giảng viên hướng dẫn không được để trống!");
        }

        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Research Topic: " + researchTopic + " | Supervisor: " + supervisorName;
    }
}
