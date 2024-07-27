/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.unipar.educarefrontend.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto.unipar.educarefrontend.util.Log;

/**
 *
 * @author leonardo
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaiDtoRequest {
    
    private String nomeCompletoPai;
    private String cpfPai;
    private String telefonePai;
    private boolean telefonePaiWhatsapp;
    private String contatoReserva;
    private boolean podeBuscar;
    private String telefoneReserva;
    private boolean telefoneReservaWhatsapp;
    
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String numero;
    
}