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
public interface CustomerWriter
{
 boolean addCustomer(Customer c);
 boolean updateCustomer(Customer c);
 boolean deleteCustomer(Customer c);
}