package carolina.nichita.addressbook.controller;

import carolina.nichita.addressbook.exception.AddressNotFoundException;
import carolina.nichita.addressbook.model.UserAddress;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import carolina.nichita.addressbook.repository.AddressBookRepository;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class AddressBookController {
    private final AddressBookRepository repository;

    public AddressBookController(AddressBookRepository repository) {
        this.repository = repository;
    }

//    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public List<UserAddress> findAll() {
        return repository.getBookList();
    }

    @GetMapping("/{id}")
    public UserAddress findById(@PathVariable String id) throws AddressNotFoundException {
        return repository.findById(id);
    }

    @GetMapping("/{fullName}")
    public UserAddress findByFullName(String fullName) throws AddressNotFoundException {
        return repository.findByFullName(fullName);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserAddress create(@Valid @RequestBody UserAddress userAddress) {
        return repository.addBook(userAddress);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody UserAddress userAddress) {
        repository.updateBook(userAddress);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws AddressNotFoundException {
        repository.deleteItem(id);
    }
}