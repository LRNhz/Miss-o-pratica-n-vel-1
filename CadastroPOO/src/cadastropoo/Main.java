/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.ArrayList;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author luisr
 */
public class Main {
    public static void Main(String[] args) {
        // Teste do repositório de pessoas físicas
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pf1 = new PessoaFisica(1, "João", "12345678909", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "Maria", "98765432109", 30);
        repo1.inserir(pf1);
        repo1.inserir(pf2);
        try {
            repo1.persistir("pessoas_fisicas.dat");
        } catch (Exception e) {
            System.out.println("Erro ao persistir dados: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoas_fisicas.dat");
        } catch (Exception e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
        ArrayList<PessoaFisica> pessoasFisicas = repo2.obterTodos();
        System.out.println("Pessoas físicas recuperadas:");
        for (PessoaFisica pf : pessoasFisicas) {
            pf.exibir();
        }

        // Teste do repositório de pessoas jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridica pj1 = new PessoaJuridica(1, "Empresa A", "12345678901234");
        PessoaJuridica pj2 = new PessoaJuridica(2, "Empresa B", "98765432101234");
        repo3.inserir(pj1);
        repo3.inserir(pj2);
        try {
            repo3.persistir("pessoas_juridicas.dat");
        } catch (Exception e) {
            System.out.println("Erro ao persistir dados: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoas_juridicas.dat");
        } catch (Exception e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
        ArrayList<PessoaJuridica> pessoasJuridicas = repo4.obterTodos();
        System.out.println("Pessoas jurídicas recuperadas:");
        for (PessoaJuridica pj : pessoasJuridicas) {
            pj.exibir();
        }
    }
}
