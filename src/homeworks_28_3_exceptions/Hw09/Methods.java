package homeworks_28_3_exceptions.Hw09;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class Methods {
    public static Optional<String> isValidMoney (List<BankAccount> accs, BankAccount originalAcc, BankAccount receiveAcc , double amount){
        if(originalAcc.getBalance() < amount) return Optional.of("số tiền rút hoặc chuyển lớn hơn số dư");

        if(amount <= 0) return Optional.of("số tiền cần lớn hơn 0.");

        boolean checkExist = accs.contains(originalAcc) && accs.contains(receiveAcc);
        if(!checkExist) return Optional.of("tài khoản nhận hoặc chuyển không tồn tại trong danh sách ");

        return Optional.empty();
    }
}
