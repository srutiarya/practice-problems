package educative.coderust.SrutiTest.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomerHashMap {
    public static void main(String[] args) throws IOException {
        Map<String, CustomerDeails> details = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        while (true){
        System.out.println("please enter your mobile number");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String phno = br.readLine();
            if (details.containsKey(phno)) {
                System.out.println("Welcome " + details.get(phno).getCusName());
                int x = times.get(phno) + 1;
                times.put(phno, x);
                if (times.get(phno) % 3 == 0) {
                    System.out.println("Hi you ll get 20% off");
                }
            } else {
                System.out.println("Please Enter your name");
                BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                String name= br1.readLine();
                System.out.println("Please Enter your email");
                BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
                String email= br2.readLine();
                CustomerDeails cusdetail=new CustomerDeails(phno,name,email);
                details.put(phno,cusdetail);
                times.put(phno,1);

            }
        }
    }
}

class CustomerDeails{
    private String cusPhno;
    private String cusName;
    private String cusEmail;

    public CustomerDeails(String cusPhno, String cusName, String cusEmail) {
        this.cusPhno = cusPhno;
        this.cusName = cusName;
        this.cusEmail = cusEmail;
    }

    public String getCusPhno() {
        return cusPhno;
    }

    public void setCusPhno(String cusPhno) {
        this.cusPhno = cusPhno;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDeails that = (CustomerDeails) o;
        return Objects.equals(cusPhno, that.cusPhno) &&
                Objects.equals(cusName, that.cusName) &&
                Objects.equals(cusEmail, that.cusEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusPhno, cusName, cusEmail);
    }
}