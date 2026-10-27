package com.gremio.controller;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    // Spring inyecta el repository automáticamente
    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    // GET /contactos → muestra la lista
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    // GET /nuevo → muestra el formulario vacío
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // GET /editar/{id} → muestra el formulario con los datos del contacto
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        return repo.findById(id)
                .map(contacto -> {
                    model.addAttribute("contacto", contacto);
                    return "nuevo";
                })
                .orElse("redirect:/contactos");
    }

    // POST /guardar → recibe el formulario y guarda en BD
    // Si el contacto trae id hace UPDATE, si no hace INSERT
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    // POST /eliminar/{id} → borra el contacto de la BD
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/contactos";
    }
}
