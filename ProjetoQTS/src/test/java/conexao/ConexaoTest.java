/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package conexao;

import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class ConexaoTest {
    
    public ConexaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of conecta method, of class Conexao.
     */
    @Test
    public void testConecta() {
        System.out.println("conecta");
        Conexao instance = new Conexao();
        boolean expResult = true;
        boolean result = instance.conecta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of desconecta method, of class Conexao.
     */
    @Test
    public void testDesconecta() {
        System.out.println("desconecta");
        Conexao instance = new Conexao();
        boolean result = instance.conecta();
        instance.desconecta();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of executaSQL method, of class Conexao.
     */
    @Test
    public void testExecutaSQL() {
        System.out.println("executaSQL");
        String sql = "select * from produto";
        Conexao instance = new Conexao();
        boolean result = instance.conecta();
        instance.executaSQL(sql);
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCreate(){
        
        System.out.println("Criar");
        int id = 30;
        String nome = "Caderno - 20 Mát.";
        String estoque = "3000";
        Conexao Cre = new Conexao();
        Cre.conecta();
        boolean result = Cre.Create(id, nome, estoque);
        
        if(result){
            JOptionPane.showMessageDialog(null, nome + " foi cadastrado com sucesso!", "Relatório de Criação", JOptionPane.INFORMATION_MESSAGE);
        }
        
        assertEquals(true, result);
        
    }
    
    @Test
    public void testRead(){
        
        System.out.println("Leitura");
        Conexao Read = new Conexao();        
        Read.conecta();
        
        boolean result = Read.Read();
        assertEquals(true, result);
        
    }
    
    @Test
    public void testUpdate(){
        
        System.out.println("Alteração");
        int id = 30;
        String nome = "Caderno - 15 Mát.";
        String estoque = "300";
        Conexao Upd = new Conexao();
        Upd.conecta();
        boolean result = Upd.Update(id, nome, estoque);
        
        if(result){
            JOptionPane.showMessageDialog(null, "O produto foi alterado com êxito.", "Relatório de Alteração", JOptionPane.INFORMATION_MESSAGE);
        }
        
        assertEquals(true, result);        
    }
    
    @Test
    public void testDelete(){
        
        System.out.println("Deletar");
        int id = 30;
        Conexao Del = new Conexao();
        Del.conecta();
        boolean result = Del.Delete(id);
        
        if(result){
            JOptionPane.showMessageDialog(null, "O produto foi excluído com sucesso!", "Relatório de Exclusão", JOptionPane.INFORMATION_MESSAGE);
        }
        
        assertEquals(true, result);
        
    }
    
}
