package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookMapper mapper;
    
    public List<BookDTO> getAll() {
        var books = repository.findAll();
        return books.stream()
                .map(mapper::map)
                .toList();
    }
    
    public BookDTO create(BookCreateDTO data) {
        var book = mapper.map(data);
        var author = authorRepository.findById(data.getAuthorId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        book.setAuthor(author);
        repository.save(book);
        return mapper.map(book);
    }
    
    public BookDTO findById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return mapper.map(book);
    }
    
    public BookDTO update(BookUpdateDTO data, Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var author = authorRepository.findById(data.getAuthorId().get())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        book.setAuthor(author);
        mapper.update(data, book);
        repository.save(book);
        return mapper.map(book);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
