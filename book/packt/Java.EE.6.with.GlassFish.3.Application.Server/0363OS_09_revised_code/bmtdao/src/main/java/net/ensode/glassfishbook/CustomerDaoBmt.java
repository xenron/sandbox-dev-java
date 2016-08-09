package net.ensode.glassfishbook;

import java.util.List;

import javax.ejb.Remote;

@Remote 
public interface CustomerDaoBmt
{
  public void saveMultipleNewCustomers(List<Customer> customerList);
}