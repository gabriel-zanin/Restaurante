package com.company;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Pratos> pratospedidolist = new ArrayList<>();
    public static List<Vinhos> winepedidoslist = new ArrayList<>();
    public static List<Bebidas> bebidaspedidoslist = new ArrayList<>();
    public static Pedidos pedido = new Pedidos();
    public static void main(String[] args) throws IOException {
        int opt;
        int i = 0;
        String select;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Scanner leitor = new Scanner(System.in);
        do {

            System.out.println("Bem vindo ao restaurante Prato Fundo! Selecione uma das opções abaixo.");
            System.out.println("1 - Cliente");
            System.out.println("2 - Gerência");

            opt = leitor.nextInt();

            if (opt == 1) {
                System.out.println("1 - Novo pedido");
                System.out.println("2 - Listar pedidos");
                opt = leitor.nextInt();
                if (opt == 1) {
                    geradorid();
//                    i++;
//                    pedido.setId(i);
                    FileWriter arquivow = new FileWriter("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pedidos.txt", true);
                    arquivow.write("\nCódigo do pedido: " + pedido.getId() + " =");
                    arquivow.close();

                    System.out.println("Sinta-se a vontade para fazer seu pedido");
                    System.out.println("Deseja escolher um prato?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    opt = leitor.nextInt();
                    if (opt == 1) {

                        System.out.println("Aqui está nosso cardápio");
                        for (Pratos prato : pratoslist()) {
                            System.out.println("Nome: " + prato.getNome() + " Preço: R$" + prato.getPreco());

                        }


                        System.out.println("Escolha seu prato");
                        select = in.readLine();
                        pratopedido(select);

                        do {
                            System.out.println("Deseja escolher mais um prato?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            opt = leitor.nextInt();

                            if (opt == 1) {
                                System.out.println("Digite o nome do prato que deseja");
                                select = in.readLine();
                                pratopedido(select);
                            }
                        } while (opt == 1);

                    }


                    opt = 1;
                    while (opt == 1) {

                        System.out.println("Deseja escolher uma bebida?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        opt = leitor.nextInt();
                        if (opt == 1) {
                            System.out.println("Aqui está nosso cardápio");
                            for (Bebidas bebida : bebidaslist()) {
                                System.out.println("Nome: " + bebida.getNome() + " Preço: R$" + bebida.getPreco());
                            }


                            System.out.println("Escolha sua bebida");
                            select = in.readLine();
                            bebidapedido(select);

                            do {
                                System.out.println("Deseja escolher mais uma bebida?");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");
                                opt = leitor.nextInt();

                                if (opt == 1) {
                                    System.out.println("Digite o nome da bebida que deseja");
                                    select = in.readLine();
                                    bebidapedido(select);
                                }
                            } while (opt == 1);
                        }
                    }

                    opt = 1;

                        System.out.println("Deseja escolher um vinho?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        opt = leitor.nextInt();

                        if (opt == 1) {

                            System.out.println("Aqui está nosso cardápio");
                            for (Vinhos vinho : winelist()) {
                                System.out.println("Nome: " + vinho.getNome() + " Preço: R$" + vinho.getPreco());
                            }


                            System.out.println("Escolha seu vinho");
                            select = in.readLine();
                            winepedido(select);

                            do {
                                System.out.println("Deseja escolher mais um vinho?");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");
                                opt = leitor.nextInt();

                                if (opt == 1) {
                                    System.out.println("Digite o nome do vinho que deseja");
                                    select = in.readLine();
                                    winepedido(select);
                                }
                }while (opt == 1);

                        }
                    finalizarpedido();
                    System.out.println("Pedido realizado com sucesso, bom apetite!");
                    opt = 0;
                    }
                if (opt == 2) {
                    pedidoslist();
                    for (Pedidos pedido : pedidoslist()) {
                        System.out.println(pedido.getIdX() + " =" + pedido.getDesc());

                    }
                    System.out.println("Deseja ver um pedido específico? Selecione uma das opções abaixo!");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    opt = leitor.nextInt();
                    if (opt == 1){
                        while (opt == 1) {
                            System.out.println("Digite o código do pedido desejado!");
                            opt = leitor.nextInt();
                            pedidoslistunit(opt);
                            System.out.println("Deseja consultar mais um pedido? Selecione uma das opções abaixo");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            opt = leitor.nextInt();
                        }
                        opt = 0;
                    }
                    if (opt == 2){
                        System.out.println("Sem problemas, continue usando o sistema!");
                        opt = 0;
                    }
                }
            }



            if (opt == 2) {

                System.out.println("Oque você deseja? Selecione uma das opções abaixo!");
                System.out.println("1 - Listar Itens");
                System.out.println("2 - Incluir Itens");
                System.out.println("3 - Editar Itens");
                System.out.println("4 - Excluir Itens");
                System.out.println("5 - Listar pedidos");
                System.out.println("6 - Excluir pedido");
                System.out.println("7 - Editar pedido");
                opt = leitor.nextInt();
                if (opt == 1) {
                    System.out.println("Quais itens você deseja listar? Selecione uma das opções abaixo!");
                    System.out.println("1 - Pratos");
                    System.out.println("2 - Bebidas");
                    System.out.println("3 - Vinhos");
                    opt = leitor.nextInt();

                    if (opt == 1) {
                        for (Pratos prato : pratoslist()) {
                            System.out.println("Nome: " + prato.getNome() + " Preço: R$" + prato.getPreco());
                        }
                    } else if (opt == 2) {
                        for (Bebidas bebida : bebidaslist()) {
                            System.out.println("Nome: " + bebida.getNome() + " Preço: R$" + bebida.getPreco());
                        }
                    } else if (opt == 3) {
                        for (Vinhos vinho : winelist()) {
                            System.out.println("Nome: " + vinho.getNome() + " Preço: R$" + vinho.getPreco());
                        }
                    }
                    opt = 0;
                }
                if (opt == 2) {
                    System.out.println("O que você deseja incluir? Selecione uma das opções abaixo!");
                    System.out.println("1 - Pratos");
                    System.out.println("2 - Bebidas");
                    System.out.println("3 - Vinhos");
                    opt = leitor.nextInt();

                    if (opt == 1) {
                        pratoinput();
                    } else if (opt == 2) {
                        bebidainput();
                    } else if (opt == 3) {
                        vinhoinput();
                    }
                    opt = 0;
                }
                if (opt == 3) {
                    System.out.println("O que você deseja editar? Selecione uma das opções abaixo!");
                    System.out.println("1 - Pratos");
                    System.out.println("2 - Bebidas");
                    System.out.println("3 - Vinhos");
                    opt = leitor.nextInt();

                    if (opt == 1) {
                        for (Pratos prato : pratoslist()) {
                            System.out.println("Nome: " + prato.getNome() + " Preço: R$" + prato.getPreco());
                        }
                        pratoedit();
                    } else if (opt == 2) {
                        for (Bebidas bebida : bebidaslist()) {
                            System.out.println("Nome: " + bebida.getNome() + " Preço: R$" + bebida.getPreco());
                        }
                        bebidaedit();
                    } else if (opt == 3) {
                        for (Vinhos vinho : winelist()) {
                            System.out.println("Nome: " + vinho.getNome() + " Preço: R$" + vinho.getPreco());
                        }
                        wineedit();
                    }
                    opt = 0;
                }
                if (opt == 4) {
                    System.out.println("O que você deseja Excluir? Selecione uma das opções abaixo!");
                    System.out.println("1 - Pratos");
                    System.out.println("2 - Bebidas");
                    System.out.println("3 - Vinhos");
                    opt = leitor.nextInt();

                    if (opt == 1) {
                        for (Pratos prato : pratoslist()) {
                            System.out.println("Nome: " + prato.getNome() + " Preço: R$" + prato.getPreco());
                        }
                        pratodelete();
                    } else if (opt == 2) {
                        for (Bebidas bebida : bebidaslist()) {
                            System.out.println("Nome: " + bebida.getNome() + " Preço: R$" + bebida.getPreco());
                        }
                        bebidadelete();
                    } else if (opt == 3) {
                        for (Vinhos vinho : winelist()) {
                            System.out.println("Nome: " + vinho.getNome() + " Preço: R$" + vinho.getPreco());
                        }
                        winedelete();
                    }


                    opt = 0;
                }
                if (opt == 5) {

                    pedidoslist();
                    for (Pedidos pedido : pedidoslist()) {
                        System.out.println(pedido.getIdX() + " =" + pedido.getDesc());

                    }
                    System.out.println("Deseja ver um pedido específico? Selecione uma das opções abaixo!");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    opt = leitor.nextInt();
                    if (opt == 1){
                        while (opt == 1) {
                            System.out.println("Digite o código do pedido desejado!");
                            opt = leitor.nextInt();
                            pedidoslistunit(opt);
                            System.out.println("Deseja consultar mais um pedido? Selecione uma das opções abaixo");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            opt = leitor.nextInt();
                        }
                        opt = 0;
                    }
                    if (opt == 2){
                        System.out.println("Sem problemas, continue usando o sistema!");
                        opt = 0;
                    }
                }
                if (opt == 6) {
                    for (Pedidos pedido : pedidoslist()) {
                        System.out.println(pedido.getIdX() + " =" + pedido.getDesc());

                    }
                    deletarpedido();
                    opt = 0;
                }
                if (opt == 7) {
                    for (Pedidos pedido : pedidoslist()) {
                        System.out.println(pedido.getIdX() + " =" + pedido.getDesc());
                    }
                    editarpedido();
                    opt = 0;
                }


            }
            System.out.println("Você deseja continuar usando o sistema? Selecione uma das opções abaixo!");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            opt = leitor.nextInt();
        } while (opt == 1);
        System.out.println("Obrigado por usar meu sistema!");
    }

    public static List<Vinhos> winelist() throws FileNotFoundException {

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\vinhos-tabulados.txt");
        Scanner leitor = new Scanner(arquivo);
        leitor.nextLine();

        List<Vinhos> winelist = new ArrayList<>();

        while (leitor.hasNext()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split("\t");
            Vinhos vinho = new Vinhos();
            vinho.setNome(partes[1]);
            vinho.setPreco(Double.parseDouble(partes[0]));
            winelist.add(vinho);
        }
        leitor.close();

        return winelist;
    }

    public static List<Pratos> pratoslist() throws FileNotFoundException {

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pratos.csv");
        Scanner leitor = new Scanner(arquivo);
        leitor.nextLine();

        List<Pratos> pratoslist = new ArrayList<>();
        while (leitor.hasNext()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split(";");
            Pratos prato = new Pratos();
            prato.setNome(partes[0]);
            prato.setPreco(Double.parseDouble(partes[1]));
            pratoslist.add(prato);
        }
        leitor.close();

        return pratoslist;
    }

    public static List<Bebidas> bebidaslist() throws FileNotFoundException {

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\bebidas-tabuladas.txt");
        Scanner leitor = new Scanner(arquivo);
        leitor.nextLine();

        List<Bebidas> bebidaslist = new ArrayList<>();
        while (leitor.hasNext()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split("\t");
            Bebidas bebida = new Bebidas();
            bebida.setNome(partes[1]);
            bebida.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
            bebidaslist.add(bebida);
        }
        leitor.close();

        return bebidaslist;
    }

    public static void pratoinput() throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner leitor = new Scanner(System.in);
        FileWriter arquivo = new FileWriter("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pratos.csv", true);


        System.out.println("Digite o nome do prato");
        String nome = in.readLine();

        System.out.println("Digite o preço");
        String preco = leitor.next();


        arquivo.write("\r" + nome);
        arquivo.write(";" + preco);


        arquivo.close();

        System.out.println("Cadastro efetuado com sucesso!");
    }

    public static void vinhoinput() throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner leitor = new Scanner(System.in);
        FileWriter arquivo = new FileWriter("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\vinhos-tabulados.txt", true);


        System.out.println("Digite o nome do vinho");
        String nome = in.readLine();

        System.out.println("Digite o preço");
        String preco = leitor.next();

        arquivo.write("\n" + preco);
        arquivo.write("\t" + nome);


        arquivo.close();

        System.out.println("Cadastro efetuado com sucesso!");

    }

    public static void bebidainput() throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner leitor = new Scanner(System.in);
        FileWriter arquivo = new FileWriter("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\bebidas-tabuladas.txt", true);


        System.out.println("Digite o nome da bebida");
        String nome = in.readLine();

        System.out.println("Digite o preço");
        String preco = leitor.next();

        arquivo.write("\n" + preco);
        arquivo.write("\t" + nome);


        arquivo.close();

        System.out.println("Cadastro efetuado com sucesso!");

    }
    public static void pratoedit() throws IOException {
        int i = 0;
        String pratox;
        String pratoy;
        double precox;


        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pratos.csv");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.csv");
        FileWriter writer = new FileWriter(temp, true);
        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        writer.write("PRATO;PREÇO\n");
        reader.nextLine();

        System.out.println("Qual prato você deseja alterar?");
        pratox = in.readLine();

        System.out.println("Qual o novo prato?");
        pratoy = in.readLine();

        System.out.println("Qual o novo preço?");
        precox = leitor.nextDouble();

        List<Pratos> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (pratoslist().get(i).getNome().contains(pratox)) {
                reader.nextLine();
                Pratos prato = new Pratos();
                prato.setNome(pratoy);
                prato.setPreco(precox);
                pratoslistx.add(prato);
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split(";");
                Pratos prato = new Pratos();
                prato.setNome(partes[0]);
                prato.setPreco(Double.parseDouble(partes[1]));
                pratoslistx.add(prato);
                i++;
            }

        }

            i = 0;
            for (Pratos prato : pratoslistx) {
                writer.write(pratoslistx.get(i).getNome() + ";" + pratoslistx.get(i).getPreco() + "\n");
                i++;
            }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);


    }
    public static void bebidaedit() throws IOException {

        int i = 0;
        String pratox;
        String pratoy;
        double precox;


        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\bebidas-tabuladas.txt");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);
        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        writer.write("PRECO\tBEBIDA\n");
        reader.nextLine();

        System.out.println("Qual bebida você deseja alterar?");
        pratox = in.readLine();

        System.out.println("Qual a nova bebida?");
        pratoy = in.readLine();

        System.out.println("Qual o novo preço?");
        precox = leitor.nextDouble();

        List<Bebidas> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (bebidaslist().get(i).getNome().contains(pratox)) {
                reader.nextLine();
                Bebidas bebida = new Bebidas();
                bebida.setNome(pratoy);
                bebida.setPreco(precox);
                pratoslistx.add(bebida);
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split("\t");
                Bebidas bebida = new Bebidas();
                bebida.setNome(partes[1]);
                bebida.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
                pratoslistx.add(bebida);
                i++;
            }


        }

        i = 0;
        for (Bebidas bebidas: pratoslistx) {
            writer.write(pratoslistx.get(i).getPreco() + "\t" + pratoslistx.get(i).getNome() + "\n");
            i++;
        }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);



    }
    public static void wineedit() throws IOException {
        int i = 0;
        String pratox;
        String pratoy;
        double precox;


        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\vinhos-tabulados.txt");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);
        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        writer.write("PRECO\tVINHO\n");
        reader.nextLine();

        System.out.println("Qual vinho você deseja alterar?");
        pratox = in.readLine();

        System.out.println("Qual o novo vinho?");
        pratoy = in.readLine();

        System.out.println("Qual o novo preço?");
        precox = leitor.nextDouble();

        List<Vinhos> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (winelist().get(i).getNome().contains(pratox)) {
                reader.nextLine();
                Vinhos wine = new Vinhos();
                wine.setNome(pratoy);
                wine.setPreco(precox);
                pratoslistx.add(wine);
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split("\t");
                Vinhos wine = new Vinhos();
                wine.setNome(partes[1]);
                wine.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
                pratoslistx.add(wine);
                i++;
            }


        }

        i = 0;
        for (Vinhos wine: pratoslistx) {
            writer.write(pratoslistx.get(i).getPreco() + "\t" + pratoslistx.get(i).getNome() + "\n");
            i++;
        }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);

    }
    public static void pratodelete() throws IOException {
        int i = 0;
        String pratox;

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pratos.csv");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.csv");
        FileWriter writer = new FileWriter(temp, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        writer.write("PRATO;PREÇO\n");
        reader.nextLine();

        System.out.println("Qual prato você deseja deletar?");
        pratox = in.readLine();


        List<Pratos> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (pratoslist().get(i).getNome().contains(pratox)) {
                reader.nextLine();
                System.out.println("Registro apagado!");
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split(";");
                Pratos prato = new Pratos();
                prato.setNome(partes[0]);
                prato.setPreco(Double.parseDouble(partes[1]));
                pratoslistx.add(prato);
                i++;
            }

        }

        i = 0;
        for (Pratos prato : pratoslistx) {
            writer.write(pratoslistx.get(i).getNome() + ";" + pratoslistx.get(i).getPreco() + "\n");
            i++;
        }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);


    }
    public static void bebidadelete() throws IOException {
        int i = 0;
        String pratox;

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\bebidas-tabuladas.txt");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        writer.write("PRECO\tBEBIDA\n");
        reader.nextLine();

        System.out.println("Qual bebida você deseja deletar?");
        pratox = in.readLine();


        List<Bebidas> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (bebidaslist().get(i).getNome().contains(pratox)) {
                reader.nextLine();
                System.out.println("Registro apagado!");
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split("\t");
                Bebidas bebida = new Bebidas();
                bebida.setNome(partes[1]);
                bebida.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
                pratoslistx.add(bebida);
                i++;
            }

        }

        i = 0;
        for (Bebidas bebida : pratoslistx) {
            writer.write(pratoslistx.get(i).getPreco() + "\t" + pratoslistx.get(i).getNome() + "\n");
            i++;
        }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);

    }
    public static void winedelete() throws IOException {
        int i = 0;
        String pratox;

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\vinhos-tabulados.txt");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        writer.write("PRECO\tVINHO\n");
        reader.nextLine();

        System.out.println("Qual vinho você deseja deletar?");
        pratox = in.readLine();


        List<Vinhos> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (winelist().get(i).getNome().contains(pratox)) {
                reader.nextLine();
                System.out.println("Registro apagado!");
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split("\t");
                 Vinhos wine = new Vinhos();
                wine.setNome(partes[1]);
                wine.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
                pratoslistx.add(wine);
                i++;
            }

        }

        i = 0;
        for (Vinhos wine : pratoslistx) {
            writer.write(pratoslistx.get(i).getPreco() + "\t" + pratoslistx.get(i).getNome() + "\n");
            i++;
        }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);

    }

    public static void pratopedido(String pratoselect) throws IOException {
        int i = 0;
        double preco = 0;
        String nome = "";
        for (Pratos prato : pratoslist()) {

            if (pratoslist().get(i).getNome().contains(pratoselect)) {
                preco = pratoslist().get(i).getPreco();
                nome = pratoslist().get(i).getNome();
            }
            i++;
        }
        if (preco == 0) {
            System.out.println("Opção inválida! Favor digitar o item corretamente");
        }else {
            Pratos prato = new Pratos();
            prato.setNome(nome);
            prato.setPreco(preco);

            pratospedidolist.add(prato);
            pedido.setPratosPedido(pratospedidolist);
            System.out.println("Item adicionado com sucesso!\n");
        }
    }
    public static void winepedido(String wineselect) throws IOException {
        int i = 0;
        double preco = 0;
        String nome = "";

        for (Vinhos vinho : winelist()) {

            if (winelist().get(i).getNome().contains(wineselect)) {
                preco = winelist().get(i).getPreco();
                nome = winelist().get(i).getNome();
            }
            i++;
        }
        if (preco == 0) {
            System.out.println("Opção inválida! Favor digitar o item corretamente");
        } else {
            Vinhos vinho = new Vinhos();
            vinho.setNome(nome);
            vinho.setPreco(preco);
            winepedidoslist.add(vinho);
            pedido.setVinhosPedido(winepedidoslist);
            System.out.println("Item adicionado com sucesso!\n");
        }
    }
    public static void bebidapedido(String bebidaselect) throws IOException {
        int i = 0;
        double preco = 0;
        String nome = "";

        for (Bebidas bebida : bebidaslist()) {

            if (bebidaslist().get(i).getNome().contains(bebidaselect)) {
                preco = bebidaslist().get(i).getPreco();
                nome = bebidaslist().get(i).getNome();
            }
            i++;
        }
        if (preco == 0) {
            System.out.println("Opção inválida! Favor digitar o item corretamente");
        } else {
            Bebidas bebida = new Bebidas();
            bebida.setNome(nome);
            bebida.setPreco(preco);
            bebidaspedidoslist.add(bebida);
            pedido.setBebidasPedido(bebidaspedidoslist);
            System.out.println("Item adicionado com sucesso!\n");
        }
    }
    public static List<Pedidos> pedidoslist() throws FileNotFoundException {
        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pedidos.txt");
        Scanner leitor = new Scanner(arquivo);
        leitor.nextLine();
        List<Pedidos> pedidoslist = new ArrayList<>();

        while (leitor.hasNext()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split("=");
            Pedidos pedido = new Pedidos();
            pedido.setDesc(partes[1]);
            pedido.setIdX((partes[0]));
            pedidoslist.add(pedido);
        }
        leitor.close();

        return pedidoslist;
    }
    public static void pedidoslistunit(int opt) throws FileNotFoundException {
        int i = 0;
        int x = 0;
        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pedidos.txt");
        Scanner leitor = new Scanner(arquivo);
        String desc = "";
        leitor.nextLine();

            for (Pedidos pedido : pedidoslist()) {

                if (pedidoslist().get(i).getIdX().contains(Integer.toString(opt))) {
                    desc = pedidoslist().get(i).getDesc();
                }

                i++;
            }
        System.out.println(desc);

    }
    public static void editarpedido() throws IOException {
        int i = 0;
        int x = 0;
        int j = 0;
        int y = 0;
        String coment = "";
        String select;
        int opt;
        String pratox;
        DecimalFormat df = new DecimalFormat("###,##0.00");
        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pedidos.txt");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner leitor = new Scanner(System.in);



        writer.write("LISTA DE PEDIDOS - RESTAURANTE PRATO FUNDO\n");
        reader.nextLine();

        System.out.println("Qual pedido você deseja alterar?");
        pratox = in.readLine();


        List<Pedidos> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (pedidoslist().get(i).getIdX().contains(pratox)) {
                reader.nextLine();
                writer.write(pedidoslist().get(i).getIdX() + " =");
                System.out.println("Deseja escolher um novo prato?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opt = leitor.nextInt();
                if (opt == 1) {

                    System.out.println("Aqui está nosso cardápio");
                    for (Pratos prato : pratoslist()) {
                        System.out.println("Nome: " + prato.getNome() + " Preço: R$" + prato.getPreco());

                    }


                    System.out.println("Escolha seu novo prato");
                    select = in.readLine();
                    pratopedido(select);

                    do {
                        System.out.println("Deseja escolher mais um prato?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        opt = leitor.nextInt();

                        if (opt == 1) {
                            System.out.println("Digite o nome do novo prato que deseja");
                            select = in.readLine();
                            pratopedido(select);
                        }
                    } while (opt == 1);

                }
                opt = 1;
                while (opt == 1) {

                    System.out.println("Deseja escolher uma nova bebida?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    opt = leitor.nextInt();
                    if (opt == 1) {
                        System.out.println("Aqui está nosso cardápio");
                        for (Bebidas bebida : bebidaslist()) {
                            System.out.println("Nome: " + bebida.getNome() + " Preço: R$" + bebida.getPreco());
                        }


                        System.out.println("Escolha sua nova bebida");
                        select = in.readLine();
                        bebidapedido(select);

                        do {
                            System.out.println("Deseja escolher mais uma bebida?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            opt = leitor.nextInt();

                            if (opt == 1) {
                                System.out.println("Digite o nome da nova bebida que deseja");
                                select = in.readLine();
                                bebidapedido(select);
                            }
                        } while (opt == 1);
                    }
                }
                opt = 1;

                System.out.println("Deseja escolher novo um vinho?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opt = leitor.nextInt();

                if (opt == 1) {

                    System.out.println("Aqui está nosso cardápio");
                    for (Vinhos vinho : winelist()) {
                        System.out.println("Nome: " + vinho.getNome() + " Preço: R$" + vinho.getPreco());
                    }


                    System.out.println("Escolha seu novo vinho");
                    select = in.readLine();
                    winepedido(select);

                    do {
                        System.out.println("Deseja escolher mais um vinho?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        opt = leitor.nextInt();

                        if (opt == 1) {
                            System.out.println("Digite o nome do novo vinho que deseja");
                            select = in.readLine();
                            winepedido(select);
                        }
                    }while (opt == 1);
                }
                System.out.println("Você deseja adicionar alguma observação ao seu pedido? Selecione uma das opções abaixo!");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                x = leitor.nextInt();
                if (x == 1) {
                    System.out.println("Digite sua observação:");
                    coment = in.readLine();
                    pedido.setComent(coment);
                }
                for (Pratos prato: pedido.getPratosPedido())
                {

                    String precoP = String.valueOf(df.format(pedido.getPratosPedido().get(j).getPreco()));
                    writer.write("      " + "Prato:" + pedido.getPratosPedido().get(j).getNome());
                    writer.write(" " + "Preço R$: " + precoP);
                    j++;
                }
                j = 0;
                for (Vinhos vinho: pedido.getVinhosPedido())
                {
                    String precoV = String.valueOf(df.format(pedido.getVinhosPedido().get(j).getPreco()));
                    writer.write("      " + "Vinho:" + pedido.getVinhosPedido().get(j).getNome());
                    writer.write(" " + "Preço R$: " + precoV);
                    j++;
                }
                j = 0;
                for (Bebidas bebida: pedido.getBebidasPedido())
                {

                    String precoB = String.valueOf(df.format(pedido.getBebidasPedido().get(j).getPreco()));
                    writer.write("      " + "Bebida:" + pedido.getBebidasPedido().get(j).getNome());
                    writer.write(" " + "Preço R$: " + precoB);
                    j++;
                }
                j = 0;
                for (Vinhos vinho: pedido.getVinhosPedido())
                {
                    pedido.setTotal(pedido.getTotal() + pedido.getVinhosPedido().get(j).getPreco());
                    j++;
                }
                j = 0;
                for (Bebidas bebida: pedido.getBebidasPedido())
                {
                    pedido.setTotal(pedido.getTotal() + pedido.getBebidasPedido().get(j).getPreco());
                    j++;
                }
                j = 0;
                for (Pratos prato: pedido.getPratosPedido())
                {
                    pedido.setTotal(pedido.getTotal() + pedido.getPratosPedido().get(j).getPreco());
                    j++;
                }
                j = 0;
                String total = String.valueOf(df.format(pedido.getTotal()));
                writer.write("\t" + "Total do pedido R$: " + total);

                if (pedido.getComent() == null) {
                    writer.write("\t" + "Sem observações especiais.\n");
                }else {
                    writer.write("\t" + "Observação: " + pedido.getComent() + "\n");
                }

                i++;
                pedido.setComent(null);
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split("=");
                Pedidos pedido = new Pedidos();
                pedido.setIdX(partes[0]);
                pedido.setDesc(partes[1]);
                pratoslistx.add(pedido);
                writer.write(pratoslistx.get(y).getIdX() + "=" + pratoslistx.get(y).getDesc() + "\n");
                y++;
                i++;
                pedido.setComent(null);
            }

        }

        pedido.getBebidasPedido().clear();
        pedido.getPratosPedido().clear();
        pedido.getVinhosPedido().clear();
        pedido.setTotal(0);
        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);
    }
    public static void deletarpedido() throws IOException {
        int i = 0;
        String pratox;

        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pedidos.txt");
        Scanner reader = new Scanner(arquivo);
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        writer.write("LISTA DE PEDIDOS - RESTAURANTE PRATO FUNDO\n");
        reader.nextLine();

        System.out.println("Qual pedido você deseja deletar?");
        pratox = in.readLine();


        List<Pedidos> pratoslistx = new ArrayList<>();
        while (reader.hasNextLine())  {
            if (pedidoslist().get(i).getIdX().contains(pratox)) {
                reader.nextLine();
                System.out.println("Registro apagado!");
                i++;
            } else {
                String linha = reader.nextLine();
                String[] partes = linha.split("=");
                Pedidos pedido = new Pedidos();
                pedido.setIdX(partes[0]);
                pedido.setDesc(partes[1]);
                pratoslistx.add(pedido);
                i++;
            }

        }

        i = 0;
        for (Pedidos pedido : pratoslistx) {
            writer.write( pratoslistx.get(i).getIdX() + "=" + pratoslistx.get(i).getDesc() + "\n");
            i++;
        }

        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);
    }
    public static void geradorid() throws IOException {
        int idnovo = 1;
        File arquivo = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\lastid.txt");
        File temp = new File("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\tmp.txt");
        FileWriter writer = new FileWriter(temp, true);

        Scanner reader = new Scanner(arquivo);

        if (reader.hasNextLine()){
            String lastid = reader.nextLine();
            idnovo = 1 + Integer.parseInt(lastid);
            pedido.setId(idnovo);
        }else {
            idnovo = 1;
            pedido.setId(idnovo);
        }




        writer.write(Integer.toString(idnovo));
        writer.close();
        reader.close();
        arquivo.delete();
        temp.renameTo(arquivo);
    }
    public static void finalizarpedido() throws IOException {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int x = 0;
        String coment = "";

        Scanner leitor = new Scanner(System.in);
        FileWriter arquivo = new FileWriter("C:\\Users\\Gabriel Fernando\\IdeaProjects\\Restaurante\\Itens\\pedidos.txt", true);
        System.out.println("Você deseja adicionar alguma observação ao seu pedido? Selecione uma das opções abaixo!");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        x = leitor.nextInt();
        if (x == 1) {
            System.out.println("Digite sua observação:");
            coment = in.readLine();
            pedido.setComent(coment);
        }
        for (Pratos prato: pedido.getPratosPedido())
        {

            String precoP = String.valueOf(df.format(pedido.getPratosPedido().get(i).getPreco()));
            arquivo.write("      " + "Prato:" + pedido.getPratosPedido().get(i).getNome());
            arquivo.write(" " + "Preço R$: " + precoP);
            i++;
        }
        i = 0;
        for (Vinhos vinho: pedido.getVinhosPedido())
        {
            String precoV = String.valueOf(df.format(pedido.getVinhosPedido().get(i).getPreco()));
            arquivo.write("      " + "Vinho:" + pedido.getVinhosPedido().get(i).getNome());
            arquivo.write(" " + "Preço R$: " + precoV);
            i++;
        }
        i = 0;
        for (Bebidas bebida: pedido.getBebidasPedido())
        {

            String precoB = String.valueOf(df.format(pedido.getBebidasPedido().get(i).getPreco()));
            arquivo.write("      " + "Bebida:" + pedido.getBebidasPedido().get(i).getNome());
            arquivo.write(" " + "Preço R$: " + precoB);
            i++;
        }
        i = 0;
        for (Vinhos vinho: pedido.getVinhosPedido())
        {
            pedido.setTotal(pedido.getTotal() + pedido.getVinhosPedido().get(i).getPreco());
            i++;
        }
        i = 0;
        for (Bebidas bebida: pedido.getBebidasPedido())
        {
            pedido.setTotal(pedido.getTotal() + pedido.getBebidasPedido().get(i).getPreco());
            i++;
        }
        i = 0;
        for (Pratos prato: pedido.getPratosPedido())
        {
            pedido.setTotal(pedido.getTotal() + pedido.getPratosPedido().get(i).getPreco());
            i++;
        }
        i = 0;


        String total = String.valueOf(df.format(pedido.getTotal()));
        arquivo.write("\t" + "Total do pedido R$: " + total);

        if (pedido.getComent() == null) {
            arquivo.write("\t" + "Sem observações especiais.");
        }else {
            arquivo.write("\t" + "Observação: " + pedido.getComent());
        }



        arquivo.close();

        pedido.getBebidasPedido().clear();
        pedido.getPratosPedido().clear();
        pedido.getVinhosPedido().clear();
        pedido.setComent(null);
        pedido.setTotal(0);
    }

}

