package app.app.service;

import app.app.entity.Servico;
import app.app.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    // Create
    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    // Read
    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servico not found with id: " + id));
    }

    // Update
    public Servico update(Long id, Servico servicoDetails) {
        Servico servico = findById(id);
        servico.setNome(servicoDetails.getNome());
        servico.setDescricao(servicoDetails.getDescricao());
        servico.setPreco(servicoDetails.getPreco());
        servico.setDuracaoMinutos(servicoDetails.getDuracaoMinutos());
        return servicoRepository.save(servico);
    }

    // Delete
    public void deleteById(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Servico not found with id: " + id);
        }
        servicoRepository.deleteById(id);
    }
    public Long buscarQtdServico(){
        return servicoRepository.buscarQtdServico();
    }


}
