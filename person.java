public class Person {

    private final String name;
    private final String surname;
    private final String telephoneNumber;
    private final String email;
    private final String address;


//    Constructor

    public Person(String name, String surname, String telephoneNumber, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }


//    Method to display all info in a readable manner

        public String toString(){
            String output = "Name: " + name;
            output += "\nSurname: " + surname;
            output += "\nTelephone Number: " + telephoneNumber;
            output += "\nEmail: " + email;
            output += "\nAddress: " + address;

            return output;
        }
    }
