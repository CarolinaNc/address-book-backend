package carolina.nichita.addressbook.controller;

import carolina.nichita.addressbook.exception.AddressNotFoundException;
import carolina.nichita.addressbook.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import carolina.nichita.addressbook.repository.BookingRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class BookController {
    private final BookingRepository repository;

    public BookController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> findAll() {
        return repository.getBookList();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) throws AddressNotFoundException {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return repository.addBook(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody User user) {
        repository.updateBook(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws AddressNotFoundException {
        repository.deleteItem(id);
    }
}