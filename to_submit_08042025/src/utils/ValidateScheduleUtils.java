package utils;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

public class ValidateScheduleUtils {
    private static final Logger logger = Logger.getLogger(ValidateScheduleUtils.class.getName());
    public static LocalDateTime[] inputValidSchedule(Scanner sc) {
        while (true) {
            System.out.println(" Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm:ss):");
            LocalDateTime start = InputUtils.validateLocalDateTime(sc);

            System.out.println("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm:ss):");
            LocalDateTime end = InputUtils.validateLocalDateTime(sc);

            Optional<String> error = validateScheduleDuration(start, end);
            if (error.isPresent()) {
                return new LocalDateTime[]{start, end};
            } else {
                logger.warning(error.get());
            }
        }
    }


    public static Optional<String> validateScheduleDuration(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return Optional.of("Không được null");
        if (!end.isAfter(start)) return Optional.of("Kết thúc phải sau bắt đầu");
        return Optional.empty();
    }



}
