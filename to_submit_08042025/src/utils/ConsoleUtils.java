package utils;

public class ConsoleUtils {
    public static void printMainMenu (){
        System.out.println("************************* UNIVERSITY MENU **********************");
        System.out.println("1. Quản lý khóa học");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("3. Quản lý sinh viên");
        System.out.println("4. Đăng ký khóa học");
        System.out.println("5. Quản lý lớp học");
        System.out.println("6. Thống kê");
        System.out.println("7. Thoát");
        System.out.println("***************************************************************");
    }

    public static void printCourseMenu (){
        System.out.println("************************* COURSE MENU *************************");
        System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
        System.out.println("2. Thêm mới khóa học");
        System.out.println("3. Cập nhật khóa học");
        System.out.println("4. Xóa khóa học theo ID (Chỉ xóa được khóa học nếu khóa học chưa có lớp học)");
        System.out.println("5. Thoát");
        System.out.println("***************************************************************");
    }


    public static void printTeacherMenu (){
        System.out.println("************************* TEACHER MENU *************************");
        System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
        System.out.println("2. Thêm mới giảng viên");
        System.out.println("3. Cập nhật giảng viên");
        System.out.println("4. Xóa giảng viên (chỉ xóa được nếu giảng viên chưa được xếp lớp)");
        System.out.println("5. Thoát");
        System.out.println("***************************************************************");
    }

    public static void printStudentMenu (){
        System.out.println("************************ STUDENT MENU ***************************");
        System.out.println("1. Danh sách sinh viên được sắp xếp theo tên tăng dần");
        System.out.println("2. Thêm mới sinh viên");
        System.out.println("3. Cập nhật sinh viên");
        System.out.println("4. Xóa sinh viên (chỉ xóa nếu sinh viên chưa đăng ký khóa học nào)");
        System.out.println("5. Thoát");
        System.out.println("***************************************************************");
    }

    public static void printCourseRegistrationMenu (){
        System.out.println("******************* COURSE REGISTRATION MENU *****************");
        System.out.println("1. Đăng ký khóa học cho sinh viên");
        System.out.println("2. Hủy đăng ký học cho sinh viên (Chỉ được hủy nếu trạng thái là PENDING)");
        System.out.println("3. Duyệt đăng ký học sinh viên (PENDING → ENROLLED)");
        System.out.println("4. Xem danh sách sinh viên đăng ký từng khóa học");
        System.out.println("5. Thoát");
        System.out.println("***************************************************************");
    }

    public static void printClassroomMenu (){
        System.out.println("********************** CLASS ROOM MENU **********************");
        System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
        System.out.println("2. Thêm mới lớp học");
        System.out.println("3. Cập nhật thông tin lớp học (Chỉ cập nhật được thông tin nếu trạng thái khác CLOSE)");
        System.out.println("4. Xóa lớp học (Chỉ xóa được nếu lớp học chưa có sinh viên và giảng viên)");
        System.out.println("5. Phân công giảng viên cho lớp");
        System.out.println("6. Thêm sinh viên vào cho lớp");
        System.out.println("7. Tạo lịch học cho lớp");
        System.out.println("8. Cập nhật trạng thái lớp (PENDING → PROGRESS → CLOSE)");
        System.out.println("9. Thoát");
        System.out.println("***************************************************************");
    }

    public static void printDashboard (){
        System.out.println("************************** DASHBOARD ***********************");
        System.out.println("1. Thống kê số sinh viên, giảng viên, khóa học, lớp học");
        System.out.println("2. Top 3 khóa học có nhiều sinh viên nhất");
        System.out.println("3. Top 3 lớp học có nhiều sinh viên nhất");
        System.out.println("4. Top 3 giảng viên dạy nhiều sinh viên nhất");
        System.out.println("5. Top 3 sinh viên đăng ký học nhiều nhất");
        System.out.println("6. Thoát");
        System.out.println("***************************************************************");
    }
}
