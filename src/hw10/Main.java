    package hw10;

    import java.util.*;
    import java.util.function.Predicate;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Set<Contact> contacts = new HashSet<>();
            Contact c1 = new Contact("duong","0987654321");
            Contact c2 = new Contact("hoang","0987612345");
            Contact c3 = new Contact("linh","0987123654");
            addUniqueContact(contacts,c1);
            addUniqueContact(contacts,c2);
            addUniqueContact(contacts,c3);
            addUniqueContact(contacts,c1);// check validate

            printContactList(contacts);
            deleteContact(contacts,sc);
            printContactList(contacts);
            searchContact(contacts,sc);

        }

        public static void addUniqueContact (Set<Contact> contacts, Contact newContact){

            Iterator<Contact> it = contacts.iterator();
            while(it.hasNext()){
                Contact contact = it.next();
                boolean checking = contact.equals(newContact);

                if(checking){
                    System.out.println("Contact với số điên thoại " + newContact.getPhoneNumber() + " đã tồn tại ");
                    return;
                }
            }
            contacts.add(newContact);

        }

        static void printContactList (Set<Contact> contacts){
            Iterator<Contact> it = contacts.iterator();
            while(it.hasNext()){
                Contact curContact = it.next();
                System.out.println(curContact.getId() + " | " + curContact.getName() + " | " + curContact.getPhoneNumber());
            }
        }

        static void deleteContact (Set<Contact> contacts, Scanner sc){
            System.out.println("Nhập số cần xóa: ");
            String delPhone = sc.nextLine();
            Iterator<Contact> it = contacts.iterator();
            while(it.hasNext()){
                Contact curContact = it.next();
                if(curContact.getPhoneNumber().equals(delPhone)){
                    it.remove();
                }
            }
        }

        static void searchContact (Set<Contact> contacts, Scanner sc){
            System.out.println("Nhập số cần tìm: ");
            String searchPhone = sc.nextLine();
            boolean found = false;

            Iterator<Contact> it = contacts.iterator();
            while(it.hasNext()){
                Contact curContact = it.next();
                if(curContact.getPhoneNumber().equals(searchPhone)){
                    System.out.println(curContact.getId() + " | " + curContact.getName() + " | " + curContact.getPhoneNumber());
                    found = true;
                    return;
                }
            }

            if(!found){
                System.out.println("không thấy");
            }
        }
    }
