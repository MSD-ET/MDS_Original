/*
 * package com.bah.msd.customerapi;
 * 
 * import com.bah.msd.api.domain.Customer; import
 * com.bah.msd.api.repository.CustomerRepository; import
 * org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * @SpringBootTest class CustomerRepositoryTests {
 * 
 * @Autowired private CustomerRepository repository;
 * 
 * @Test void test_addNewCustomer() {
 * 
 * System.out.println("repository count: " + repository.count());
 * assertThat(repository.count()).isEqualTo(1);
 * 
 * assertThat(repository.existsByEmail("mickknutson@gmail.com")).isTrue(); //
 * assertThat(repository.existsByName("Mick")).isTrue();
 * 
 * Customer c = new Customer(); c.setName("Mick");
 * c.setEmail("mickknutson@gmail.com"); c.setPassword("password");
 * 
 * System.out.println("Original c: " + c.toString());
 * 
 * Customer newCustomer = repository.save(c);
 * 
 * System.out.println("New c: " + newCustomer.toString());
 * 
 * System.out.println("repository count: " + repository.count());
 * assertThat(repository.count()).isEqualTo(2);
 * 
 * }
 * 
 * }
 */
