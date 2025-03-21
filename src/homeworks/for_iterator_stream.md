
| Tiêu chí                   | for-loop                         | Iterator                              | Stream                             |
|----------------------------|----------------------------------|----------------------------------------|------------------------------------|
| Cú pháp                    | `for (int i = 0; i < n; i++)`    | `while (iterator.hasNext())`          | `list.stream().forEach(...)`       |
| Tốc độ (danh sách nhỏ)     | Rất nhanh             | Nhanh nhất                  | Chậm hơn  do overhead     |
| Tốc độ (danh sách lớn)     | Chậm | Trung bình                   | Nhanh nhất , có thể song song |
| Mức độ                     | Dễ hiểu                          | Hơi dài dòng                           | Ngắn gọn, dễ đọc                    |
| Truy cập theo chỉ số       | Có thể                           | Không hỗ trợ                           | Không hỗ trợ                        |
| Xóa phần tử khi duyệt      | Gây lỗi                          | An toàn với `iterator.remove()`        | Không hỗ trợ                        |
| Tùy biến logic khi duyệt   | Linh hoạt                        | Linh hoạt                              | Cực kỳ linh hoạt (map, filter, reduce) |
| Phiên bản Java yêu cầu     | Java 1.2+                        | Java 1.2+                              | Java 8+                             |
| Hỗ trợ đa luồng (parallel) | Không                            | Không                                  | Có (`parallelStream()`)            |
| Phù hợp cho danh sách nhỏ  | Rất phù hợp                      | Phù hợp                                 | Không khuyến khích                 |
| Phù hợp cho danh sách lớn  | Không hiệu quả                   | Tạm ổn                                 | Tối ưu nhất với `parallelStream()` |



| Nhu cầu                                | Nên dùng      |
|----------------------------------------|----------------------|
| Truy cập phần tử theo chỉ số           | `for-loop`           |
| Xóa phần tử khi duyệt                  | `Iterator`           |
| Xử lý dữ liệu lớn, hiệu suất cao       | `Stream`   |
| Duyệt nhanh danh sách nhỏ              | `for-loop` hoặc `Iterator` |
