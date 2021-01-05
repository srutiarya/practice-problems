package educative.coderust.SrutiTest.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class HotelHashmap {
    public static void main(String[] args) throws IOException {
        HashMap<Long,Customer> details=new HashMap<>();
        HashMap<Long,Integer> times=new HashMap<>();

        while(true){
            System.out.println("please enter phone number");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Long phno=Long.valueOf(br.readLine());
            if(details.containsKey(phno)){
                System.out.println("Welcome "+details.get(phno).getName());
                int x=times.get(phno)+1;
                times.put(phno,x);
                if(times.get(phno)%3==0){
                    System.out.println("Hi you will get 20% off");
                }

            }
            else {
                System.out.println("please enter your name");
                BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                String name=br1.readLine();
                System.out.println("please enter your email");
                BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
                String email=br1.readLine();
                Customer cs=new Customer(name,phno,email);
                details.put(cs.getPhno(),cs);
                times.put(cs.getPhno(), 1);
            }

        }
    }

}

class Customer{
    String name;
    Long phno;
    String email;

    public Customer(String name, Long phno, String email) {
        this.name = name;
        this.phno = phno;
        this.email = email;
    }
    public Customer(Long phno){
        this.phno=phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(phno, customer.phno) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phno, email);
    }
}