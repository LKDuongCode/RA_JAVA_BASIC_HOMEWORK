package java_oop_practice;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Book[] books = new Book[100];
        int curIdx = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("MENU =====================================");
            System.out.println("1. hiển thị danh sách sách ");
            System.out.println("2. thêm mới sách");
            System.out.println("3. tính lợi nhuận của các sách");
            System.out.println("4. cập nhật sách");
            System.out.println("5. xóa sách");
            System.out.println("6. sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. tìm kiếm sách theo tác giả");
            System.out.println("8. tìm kiếm sách theo khoảng giá");
            System.out.println("9. thống kê sách theo mỗi tác giả");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    if (curIdx == 0) {
                        System.out.println("Danh sách sách trống.");
                        break;
                    }else {
                        for (int i = 0; i < curIdx; i++) {
                            books[i].displayData();
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    break;
                case 2:
                    if (curIdx >= books.length) {
                        System.out.println("Danh sách sách đầy");
                        break;
                    }else {
                        Book newBook = new Book();
                        newBook.inputData(sc);
                        books[curIdx++] = newBook;
                        System.out.println("Thêm thành công!");
                    }
                    break;
                case 3:
                    if (curIdx == 0) {
                        System.out.println("Danh sách sách trống.");
                        break;
                    }else {
                        for (int i = 0; i < curIdx; i++) {
                            books[i].calInterest();
                            System.out.println(books[i].getBookName() + " - Lợi nhuận: " + books[i].getInterest());
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < curIdx; i++) {
                        System.out.println("[ " + books[i].getBookId() + " ]");
                    }

                    System.out.print("Nhập mã sách cần cập nhật: ");
                    String bookId = sc.nextLine();
                    int bookIndex = -1;

                    for (int i = 0; i < curIdx; i++) {
                        if (books[i].getBookId().equals(bookId)) {
                            bookIndex = i;
                            break;
                        }
                    }

                    if (bookIndex !=  -1) {
                        int option;
                        do {
                            System.out.println("\nThông tin về sách ID " + books[bookIndex].getBookId());
                            System.out.println("1. Tên sách: " + books[bookIndex].getBookName());
                            System.out.println("2. Giá nhập: " + books[bookIndex].getImportPrice());
                            System.out.println("3. Giá bán: "+ books[bookIndex].getExportPrice());
                            System.out.println("4. Tiêu đề: "+ books[bookIndex].getTitle());
                            System.out.println("5. Tác giả: "+ books[bookIndex].getAuthor());
                            System.out.println("6. Năm xuất bản: "+ books[bookIndex].getYear());
                            System.out.println("7. Quay lại");
                            System.out.print("Bạn muốn sửa phần nào: ");
                            option = Integer.parseInt(sc.nextLine());

                            switch (option) {
                                case 1:
                                    System.out.println("Nhập tên sách mới (6-100 ký tự): ");
                                    books[bookIndex].setBookName(sc.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Nhập giá nhập mới: ");
                                    double upEx = Double.parseDouble(sc.nextLine());
                                    books[bookIndex].setImportPrice(upEx);
                                    books[bookIndex].calInterest();
                                    break;
                                case 3:
                                    System.out.println("Nhập giá bán mới: ");
                                    double upIm = Double.parseDouble(sc.nextLine());
                                    books[bookIndex].setExportPrice(upIm);
                                    books[bookIndex].calInterest();
                                    break;
                                case 4:
                                    System.out.println("Nhập tiêu đề mới: ");
                                    books[bookIndex].setTitle(sc.nextLine());
                                    break;
                                case 5:
                                    System.out.println("Nhập tác giả mới: ");
                                    books[bookIndex].setAuthor(sc.nextLine());
                                    break;
                                case 6:
                                    System.out.println("Nhập năm xuất bản mới (>= 1970): ");
                                    int upYear = Integer.parseInt(sc.nextLine());
                                    books[bookIndex].setYear(upYear);
                                    break;
                                case 7:
                                    System.out.println("---------");
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ");
                            }
                        } while (option != 7);
                    } else {
                        System.out.println("Không tìm thấy sách.");
                    }
                    break;
                case 5:
                    System.out.println("Bạn có chắc muốn xóa sách?");
                    System.out.println("1. đúng vậy");
                    System.out.println("2. không");
                    int delConfirm = Integer.parseInt(sc.nextLine());
                    if (delConfirm == 2){
                        break;
                    }else if (delConfirm ==1){
                        System.out.println("Nhập mã sách cần xóa: ");
                        String delBookId = sc.nextLine();
                        boolean found = false;
                        for (int i = 0; i < curIdx; i++) {
                            if (books[i].getBookId().equals(delBookId)) {
                                System.arraycopy(books, i + 1, books, i, curIdx - i - 1);
                                curIdx--;
                                System.out.println("Sách đã được xóa.");
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Không tìm thấy sách.");
                    }else {
                        System.out.println("lựa chọn không hợp lệ.");
                        break;
                    }
                    break;
                case 6:
                    if (curIdx == 0) {
                        System.out.println("Danh sách sách trống.");
                        break;
                    } else {
                        for (int i = 0; i < curIdx - 1; i++) {
                            for (int j = 0; j < curIdx - i - 1; j++) {
                                if (books[j].getInterest() > books[j + 1].getInterest()) {
                                    Book temp = books[j];
                                    books[j] = books[j + 1];
                                    books[j + 1] = temp;
                                }
                            }
                        }
                        System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần.");
                    }
                    break;
                case 7:
                    if (curIdx == 0) {
                        System.out.println("Danh sách sách trống.");
                        break;
                    }

                    System.out.print("Nhập tên tác giả cần tìm: ");
                    String author = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < curIdx; i++) {
                        if (books[i].getAuthor().equalsIgnoreCase(author)) {
                            books[i].displayData();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy tác giả " + author);
                    break;
                case 8:
                    if (curIdx == 0) {
                        System.out.println("Danh sách sách trống.");
                        break;
                    }

                    System.out.print("Nhập giá thấp nhất: ");
                    double minPrice = Double.parseDouble(sc.nextLine());

                    System.out.print("Nhập giá cao nhất: ");
                    double maxPrice = Double.parseDouble(sc.nextLine());

                    if (minPrice > maxPrice) {
                        System.out.println("Giá thấp nhất không thể lớn hơn giá cao nhất.");
                        break;
                    }

                    boolean foundByPrice = false;
                    System.out.println("Sách trong khoảng " + minPrice + " - " + maxPrice);

                    for (int i = 0; i < curIdx; i++) {
                        if (books[i] != null && books[i].getExportPrice() >= minPrice && books[i].getExportPrice() <= maxPrice) {
                            books[i].displayData();
                            foundByPrice = true;
                        }
                    }

                    if (!foundByPrice) {
                        System.out.println("Không có sách nào trong khoảng giá này.");
                    }
                    break;
                case 9:
                    if (curIdx == 0) {
                        System.out.println("Danh sách sách trống.");
                        break;
                    }
                    // tạo mảng chứa tên tác giả và mảng chứa các mảng con chứa sách
                    String[] authors = new String[curIdx];
                    Book[][] groupBooks = new Book[curIdx][curIdx];
                    int authorCount = 0; // Số lượng tác giả duy nhất

                    // duyệt mảng books để thêm tác vào mảng authors và thêm sách vào mảng con
                    for (int i = 0; i < curIdx; i++) {
                        String currentAuthor = books[i].getAuthor();
                        int authorIndex = -1;

                        for (int j = 0; j < authorCount; j++) {
                            if (authors[j].equals(currentAuthor)) {
                                authorIndex = j; // Tác giả đã tồn tại thì kiểm tra sách có trong mảng sách con không
                                break;
                            }
                        }

                        if (authorIndex == -1) {
                            authors[authorCount] = currentAuthor;
                            groupBooks[authorCount][0] = books[i]; // Gán sách đầu tiên vào nhóm
                            authorCount++;
                        } else {
                            int bookIndexAuthor = 0;
                            while (groupBooks[authorIndex][bookIndexAuthor] != null) {
                                if (groupBooks[authorIndex][bookIndexAuthor].getBookId().equals(books[i].getBookId())) {
                                    break; // Nếu sách đã tồn tại trong nhóm, bỏ qua
                                }
                                bookIndexAuthor++;
                            }
                            if (groupBooks[authorIndex][bookIndexAuthor] == null) {
                                groupBooks[authorIndex][bookIndexAuthor] = books[i]; // Thêm sách vào nhóm
                            }
                        }
                    }

                    for (int i = 0; i < authorCount; i++) {
                        System.out.println(authors[i] + ":");
                        int bookIndexAuthor = 0;
                        while (groupBooks[i][bookIndexAuthor] != null) {
                            System.out.println(" - " + groupBooks[i][bookIndexAuthor].getBookName());
                            bookIndexAuthor++;
                        }
                    }
                    break;
                case 10:
                    System.out.println("Thoát chương trình");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while (true);

    }
}
