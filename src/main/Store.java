package main;

import model.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Game> games;
    private static ArrayList<Game> soldGames;

    public static void main(String[] args) {
        games = new ArrayList<>();
        soldGames = new ArrayList<>();
        System.out.println("-----------------------------------------------------------");
        System.out.println(" ____   ___  _   _ _     ____ _____ ___  ____  _____ ");
        System.out.println("/ ___| / _ \\| | | | |   / ___|_   _/ _ \\|  _ \\| ____|");
        System.out.println("\\___ \\| | | | | | | |   \\___ \\ | || | | | |_) |  _|  ");
        System.out.println(" ___) | |_| | |_| | |___ ___) || || |_| |  _ <| |___ ");
        System.out.println("|____/ \\___/ \\___/|_____|____/ |_| \\___/|_| \\_\\_____|");
        System.out.println("-----------------------------------------------------------");
        System.out.println("--------------Bem vindo a SOULSTORE-----------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("---Selecione uma operação que deseje realizar----------");
        menu();
    }

    public static void menu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar jogo    |");
        System.out.println("|   Opção 2 - Registrar venda   |");
        System.out.println("|   Opção 3 - Listar jogos      |");
        System.out.println("|   Opção 4 - Atualizar infos   |");
        System.out.println("|   Opção 5 - Sair              |");

        int option = input.nextInt();

        switch (option) {
            case 1:
                registerGame();
                break;
            case 2:
                registerSale();
                break;
            case 3:
                gameList();
                break;
            case 4:
                updateInfo();
                break;
            case 5:
                System.out.println("-----------Volte sempre!--------------");
                System.exit(05);
                break;
            default:
                System.out.println("Opção invalida, tente novamente!");
                menu();
                break;
        }

    }

    private static void registerGame() {
        input.nextLine();

        System.out.println("Nome do jogo: ");
        String title = input.nextLine();

        System.out.println("Gênero do jogo: ");
        String genre = input.nextLine();

        System.out.println("Preço do jogo: ");
        double price = input.nextDouble();

        Game game = new Game(title, genre, price);
        games.add(game);

        System.out.println(game.getTitle() + " cadastrado com sucesso!");
        menu();
    }

    private static void registerSale() {
        if (games.size() > 0) {

            System.out.println("-------Jogos cadastrados------");
            for (int i = 0; games.size() > i; i++) {
                System.out.println((i + 1) + games.get(i).toString());
            }

            System.out.println("Digite o código do jogo: ");
            int id = input.nextInt();
            id -= 1;
            System.out.println(games.get(id).getTitle() + " foi vendido! ");
            soldGames.add(games.get(id));
            games.remove(id);
        } else {
            System.out.println("Nenhum jogo para ser vendido!");
            menu();
        }
        menu();
    }

    private static void gameList() {
        if (games.size() > 0 || soldGames.size() > 0) {
            System.out.println("Lista de jogos: ");

            for (Game g : games) {
                System.out.println(g);
            }

            if (soldGames.size() > 0) {
                System.out.println("-------------------------");
                System.out.println("Lista de jogos vendidos: ");

                for (Game sg : soldGames) {
                    System.out.println(sg);
                }
            }

        } else {
            System.out.println("Nenhum jogo foi cadastrado!");
        }
        menu();
    }

    private static void updateInfo() {
        if (games.size() > 0) {
            System.out.println("----Jogos cadastrados------");

            for (int i = 0; games.size() > i; i++) {
                System.out.println((i + 1) + games.get(i).toString());
            }
            System.out.println("Digite o código do jogo a ser alterado: ");
            int id = input.nextInt();
            id -= 1;

            System.out.println("----Digite o tipo de alteração----");
            System.out.println("|   Opção 1 - Alterar titulo  |");
            System.out.println("|   Opção 2 - ALterar género  |");
            System.out.println("|   Opção 3 - Alterar preço   |");
            System.out.println("|   Opção 4 - Remover jogo    |");
            System.out.println("|   Opção 5 - Voltar          |");

            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Digite o novo titulo: ");
                    String title = input.nextLine();
                    games.get(id).setTitle(title);
                    System.out.println("Titulo atualizado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o novo género: ");
                    String genre = input.nextLine();
                    games.get(id).setGenre(genre);
                    System.out.println("Género atualizado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o novo valor: ");
                    Double price = input.nextDouble();
                    games.get(id).setPrice(price);
                    System.out.println("Preço atualizado com sucesso!");
                    break;
                case 4:
                    System.out.println(id + "removido com sucesso!");
                    games.remove(id);
                    break;
                case 5:
                    menu();
                default:
                    System.out.println("Opção invalida, tente novamente!");
                    break;
            }
        } else {
            System.out.println("Nenhum jogo para ser alterado");
        }
        menu();
    }
}
