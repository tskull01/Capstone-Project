/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;

/**
 *
 * @author Tskulley
 */
public class Customer {
    private String email;
    private String firstName;
    private String lastName;
   public Customer()
    {
        this("", "", "");
    }
    public Customer(String email, String firstName, String lastName)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getLastName()
    {
        return lastName;
    }
   public boolean equals(Object object)
    {
        if (object instanceof Customer)
        {
            Customer customer2 = (Customer) object;
            if
            (
                email.equals(customer2.getEmail()) &&
                firstName.equals(customer2.getFirstName()) &&
                lastName.equals(customer2.getLastName())
            )
                return true;
        }
        return false;
    }
    public String toString()
    {
        return "Email:        " + email + "\n" +
               "First Name: " + firstName + "\n" +
               "Last Name:       " + lastName + "\n";
    }
}


