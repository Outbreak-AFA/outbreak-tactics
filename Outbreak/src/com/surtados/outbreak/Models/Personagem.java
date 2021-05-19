package com.surtados.outbreak.Models;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Utils.Dados;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Personagem {
    private int playerId;
    public Sprite sprite = new Sprite();
    private String nome;
    private int vida, mana, atk, def, agl;
    private int surtoAcumulado;
    private boolean surtado = false;
    private int contadorSurto;
    public Coordenada coord = new Coordenada();
    public ArrayList<Item> inventario = new ArrayList<>();
    private Item itemEspecial;
    private boolean moveu = false, atacou = false;
    private String atkNatural;
    private String habilidadeEspecial;
    private boolean suporte = false;
    public Player dono;

    public Personagem(Player p) {
        dono = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAgl() {
        return agl;
    }

    public void setAgl(int agl) {
        this.agl = agl;
    }

    public int getSurtoAcumulado() {
        return surtoAcumulado;
    }

    public void setSurtoAcumulado(int surtoAcumulado) {
        this.surtoAcumulado = surtoAcumulado;
    }

    public void acumularSurto(int s) {
        setSurtoAcumulado(getSurtoAcumulado() + s);
    }

    public boolean isSurtado() {
        return surtado;
    }

    public void setSurtado(boolean surtado) {
        this.surtado = surtado;
    }

    public int getContadorSurto() {
        return contadorSurto;
    }

    public void setContadorSurto(int contadorSurto) {
        this.contadorSurto = contadorSurto;
    }

    public int getPlayerId() {
        return playerId;
    }

    public Item getItemEspecial() {
        return itemEspecial;
    }

    public void setItemEspecial(Item itemEspecial) {
        this.itemEspecial = itemEspecial;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getAtkNatural() {
        return atkNatural;
    }

    public void setAtkNatural(String atkNatural) {
        this.atkNatural = atkNatural;
    }

    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public boolean isSuporte() {
        return suporte;
    }

    public void setSuporte(boolean suporte) {
        this.suporte = suporte;
    }

    public abstract void atacarNatural(Personagem p);
    public abstract void habilidadeEspecial(Personagem p);

    public void modoSurto(int atk, int def, int agl) {
        if (podeSurtar()) {
            System.out.println(getNome() + " ativou o modo surto!");
            setAtk(getAtk() + atk); setDef(getDef() + def); setAgl(getAgl() + agl);
            setSurtado(true);
            setContadorSurto(3);
            setSurtoAcumulado(0);
        } else System.out.println(getNome() + " não está com o modo surto disponível!\n" + "Faltam: " + (50 - getSurtoAcumulado()));
    }

    public void passarTurno() {
        if(getContadorSurto() > 0) setContadorSurto(getContadorSurto() - 1);
        setMoveu(false);
        setAtacou(false);

    }

    public void andar(int x, int y) {
        System.out.println(this.getNome() + " andou " + x + " e " + y);
    }

    public void retirarVida(int dano) {
        setVida(getVida() - dano);
    }

    public int calcularDano(int danoMaximoOferecido, Personagem p) {
        int probabilidadeCritico = Dados.random(20);
        int probabilidadeDefesa = Dados.random(20);
        // calcular o dano máximo possível

        int dano = getAtk() * Dados.random(danoMaximoOferecido);
        if (probabilidadeCritico >= 19) dano *= getAtk();

        // calcular dano com a defesa
        if (probabilidadeDefesa >= 19) {
            dano -= Math.pow(p.getDef(), 2);
        } else if (probabilidadeDefesa >= 10) {
            dano -= p.getDef();
        } else dano -= (int)(p.getDef() / 2);

        if (dano < 0) dano = 0;

        return dano;
    }

    public abstract void ativarModoSurto();

    public boolean podeSurtar() {
        if (getSurtoAcumulado() >= 20) return true;
        return false;
    }

    public void aumentarSurto(int danoRecebido) {
        setSurtoAcumulado(getSurtoAcumulado() + (danoRecebido * Dados.random(4) / 10));
    }

    public void mostrarStatus() {
        System.out.println("========="+ getNome() +"=========");
        System.out.println("Vida: " + getVida());
        System.out.println("Mana: " + getMana());
        System.out.println("ATK: " + getAtk());
        System.out.println("DEF: " + getDef());
        System.out.println("AGL: " + getAgl());
        System.out.println("Surto acumulado: " + getSurtoAcumulado());
        System.out.println("=======================================");
    }

    public void listarItens() {
        for (Item i : inventario) {
            System.out.println(inventario.indexOf(i) + ": " + i.getTipoDeItem());
        }
    }

    public String usarItem(Item i) {
        int valorDados = Dados.random(20) + Dados.random(20) + Dados.random(20);
        switch (i.getTipoDeItem()) {
            case "MANA":
                setMana(getMana() + valorDados);
                return getNome() + " recuperou " + valorDados + " de mana!";
            case "CURA":
                setVida(getVida() + valorDados);
                return getNome() + " recuperou " + valorDados + " de vida!";
        }
        inventario.remove(i);
        return "";
    }

    public boolean morreu() {
        if (getVida() > 0) return false;
        setVida(0);
        return true;
    }

    public void mover(int linha, int coluna, Mapa mapa) {
        mapa.setMatriz(sprite.getCharacter(), linha, coluna, coord.getLinha(), coord.getColuna());
        coord.setPosicao(linha, coluna);
        Item temp = null;

        for (Item i : mapa.items) {
            if (i != null && i.coord.equals(coord)) {
                System.out.println(getNome() + " encontrou " + i.getNome());
                if (i.getTipoDeItem().equals("CURA") || i.getTipoDeItem().equals("MANA")) {
                    inventario.add(i);
                } else {
                    temp = i;
                    Sistema.adicionarConquista(i, dono);
                }
            }
        }
        if (temp != null) {
            mapa.removerItem(temp);
        }

        setMoveu(true);
    }

    public abstract String descricao();

    public String equiparItem(Item i) {
        setItemEspecial(i);
        if (i.getTipoDeItem().equals("ATK")) {
            setAtk(getAtk() * 2);
            return getNome() + " dobrou o seu ataque com " + i.getNome() + "!";
        } else if (i.getTipoDeItem().equals("DEF")) {
            setDef(getDef() * 2);
            return getNome() + " dobrou o sua defesa com " + i.getNome() + "!";
        } else if (i.getTipoDeItem().equals("AGL")) {
            setAgl(getAgl() + 2);
            return getNome() + " ganhou mais " + 2 + " pontos de agilidade com " + i.getNome() + "!";
        }
        return "Ocorreu um problema ao identificar o item :(";
    }

    public void preenchimentoPorInundacao(Mapa mapa, int lin, int col, ArrayList<Coordenada> proibidos, ArrayList<Coordenada> possiveis, boolean identificarPersonagem) {
        int colMax = mapa.getColunaMax(), linMax = mapa.getLinhaMax();
        if ((lin < 1|| lin >= linMax - 1) || (col < 1 || col >= colMax - 1) || ((!coord.equals(lin, col)) && (!mapa.posicaoVazia(lin, col, proibidos, identificarPersonagem))) || (!verificarPossiveis(possiveis, lin, col))) {
            return;
        } else {
            Coordenada co = new Coordenada();
            co.setPosicao(lin, col);
            if (!coord.equals(lin, col)) {
                possiveis.add(co.clone());
            }
            preenchimentoPorInundacao(mapa, (lin + 1), (col), proibidos, possiveis, identificarPersonagem);
            preenchimentoPorInundacao(mapa, (lin - 1), (col), proibidos, possiveis, identificarPersonagem);
            preenchimentoPorInundacao(mapa, (lin), (col + 1), proibidos, possiveis, identificarPersonagem);
            preenchimentoPorInundacao(mapa, (lin), (col - 1), proibidos, possiveis, identificarPersonagem);
        }
    }

    

    private boolean verificarPossiveis(ArrayList<Coordenada> possiveis, int lin, int col) {
        for (Coordenada c : possiveis) {
            if (c.equals(lin, col)) return false;
        }
        return true;
    }

    private ArrayList<Coordenada> getAlcanceProibido() {
        ArrayList<Coordenada> proibidos = new ArrayList<>();
        Coordenada temp = new Coordenada();
        if (getAgl() == 2) {
            //Agilidade nivel 2
            for (int lin=-2; lin<=2; lin++) {
                for (int col=-2; col<=2; col++) {
                    if (!((col == lin || col == -lin) ||
                     (col == 0 && (lin == -1 || lin == 1)) ||
                     (lin == 0 && (col == -1 || col == 1)))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
        } 
        else if (getAgl() == 4) {
            for (int lin=-2; lin<=2; lin++) {
                for (int col=-2; col<=2; col++) {
                    if (!((col == lin || col == -lin) || (lin == 0 || col == 0))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
            temp.setPosicao(coord.getLinha() - 3, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 3);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 3, coord.getColuna());
            proibidos.add(temp.clone());

        }
        else if (getAgl() == 6) {
            for (int lin=-3; lin<=3; lin++) {
                for (int col=-3; col<=3; col++) {
                    if (!((col == lin || col == -lin) || (lin == 0 || col == 0) || ((lin == -3 || lin == 3) && (col == -2 || col == 2)) || (((col == -3 || col == 3) && (lin == -2 || lin == 2))))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());

        }
        else if (getAgl() == 8) {
            for (int lin=-3; lin<=3; lin++) {
                for (int col=-3; col<=3; col++) {
                    if (!(((col == lin || col == -lin) && (col != -2 && col != 2)) || (lin == 0 || col == 0) ||
                            ((lin == -3 || lin == 3) && (col == -2 || col == 2)) ||
                            (((col == -3 || col == 3) && (lin == -2 || lin == 2))) ||
                            ((lin == -2 || lin == 2) && (col == -1 || col == 1)) ||
                            ((col == -2 || col == 2) && (lin == -1 || lin == 1)))) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
            temp.setPosicao(coord.getLinha() - 4, coord.getColuna());
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() - 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha(), coord.getColuna() + 4);
            proibidos.add(temp.clone());
            temp.setPosicao(coord.getLinha() + 4, coord.getColuna());
            proibidos.add(temp.clone());

        }
        else if (getAgl() == 10) {
            for (int lin=-4; lin<=4; lin++) {
                for (int col=-4; col<=4; col++) {
                    if (!(col == lin || col == -lin) &&
                        (((lin == -4 || lin == 4))) ||
                        (((col == -4 || col == 4))) ) {
                        temp.setPosicao(coord.getLinha() + lin, coord.getColuna() + col);
                        proibidos.add(temp.clone());
                    }
                }
            }
        }
        return proibidos;
    }

    public ArrayList<Coordenada> getAlcance(Mapa mapa) {
        ArrayList<Coordenada> proibidos = getAlcanceProibido();
        ArrayList<Coordenada> possiveis = new ArrayList<>();
        preenchimentoPorInundacao(mapa, coord.getLinha(), coord.getColuna(), proibidos, possiveis, true);
        return possiveis;
    }

    public boolean moveu() {
        return moveu;
    }

    public boolean atacou() {
        return atacou;
    }

    public void setMoveu(boolean movimentou) {
        moveu = movimentou;
    }

    public void setAtacou(boolean atk) {
        atacou = atk;
    }

   public ArrayList<Coordenada> getAlcanceAtk(int opcao, Mapa mapa) {
       ArrayList<Coordenada> proibidos = getAlcanceAtkProibido(opcao);
       ArrayList<Coordenada> possiveis = new ArrayList<>();
       preenchimentoPorInundacao(mapa, coord.getLinha(), coord.getColuna(), proibidos, possiveis, false);
       return possiveis;
   }
   public abstract ArrayList<Coordenada> getAlcanceAtkProibido(int opcao);
        
    public void menuOpcoes(Mapa mapa) {
        System.out.println("===================================================");
        System.out.println("Escolha uma ação para " + getNome());
        System.out.println("[1] - Mover");
        System.out.println("[2] - Atacar");
        System.out.println("[3] - Item");
        System.out.println("[4] - Concluir");
        if (podeSurtar()) System.out.println("[5] - SURTAR");
        System.out.println("===================================================");
        System.out.print(">>> ");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        if (opcao == 1  && !moveu()) {
                ArrayList<Coordenada> alcance = getAlcance(mapa);
                System.out.println("Escolha a posição para a qual deseja mover: ");
                ArrayList<Obstaculo> obstaculos = new ArrayList<>();
                for (Coordenada c : alcance) {
                    Obstaculo obs = new Obstaculo('#');
                    obs.coord.setPosicao(c.getLinha(), c.getColuna());
                    obstaculos.add(obs);
                    mapa.inserirObsetaculo(obs);
                }
                mapa.plotarMatriz();
            System.out.println("Posição atual: " + "(" + coord.getLinha() + ", " + coord.getColuna() + ")");
                for (Coordenada co : alcance) {
                    System.out.println("[" + (alcance.indexOf(co) + 1) + "] - (" + co.getLinha() + ", " + co.getColuna() + ")");
                }
            System.out.println("[" + (alcance.size()+1) + "] - Voltar menu.");
                int escolha = scan.nextInt();
                for (Obstaculo o : obstaculos) {
                    mapa.removerObstaculo(o);
                }
                if (escolha == alcance.size() + 1) {
                    System.out.println("Certo! Voltando para menu de ações.");
                    menuOpcoes(mapa);
                    return;
                }
                if (escolha < 1 || escolha > alcance.size()) {
                    System.out.println("Opção inválida");
                    menuOpcoes(mapa);
                    return;
                }
                mover(alcance.get(escolha-1).getLinha(), alcance.get(escolha-1).getColuna(), mapa);
                menuOpcoes(mapa);
                return;
        } else if (opcao == 2 && !atacou()) {
            System.out.println("Ótimo! Escolha qual tipo de ataque realizar:");
            System.out.println("[1] - " + getAtkNatural());
            System.out.println("[2] - " + getHabilidadeEspecial());
            int optAtk = scan.nextInt();

            if (optAtk != 1 && optAtk != 2) {
                System.out.println("Opção Inválida!");
                menuOpcoes(mapa);
                return;
            }
            
            System.out.println("Escolha o oponente em que irá atacar: ");
            ArrayList<Coordenada> alcance = getAlcanceAtk(optAtk, mapa);
            ArrayList<Personagem> alvos = new ArrayList<>();
            for (Coordenada c : alcance) {
                Personagem p = mapa.getPosicaoPersonagem(c.getLinha(), c.getColuna());
                if (isSuporte() && optAtk == 2 && p != null) {
                    alvos.add(p);
                }
                else if (p != null && p.getPlayerId() != getPlayerId()) alvos.add(p);
            }
            
            for (Personagem p : alvos) {
                System.out.println("[" + (alvos.indexOf(p) + 1) + "] - " + p.getNome());
            }
            System.out.println("["+ (alvos.size() + 1)+"] - Cancelar");
            System.out.print(">>> ");
            int vitima = scan.nextInt();
            if (vitima == alvos.size() + 1) {
                System.out.println("Certo! Voltando para menu de ações.");
                menuOpcoes(mapa);
                return;
            }
            if (vitima < 1 || vitima > alvos.size()) {
                System.out.println("Opção inválida");
                menuOpcoes(mapa);
                return;
            }
            if (optAtk == 1) atacarNatural(alvos.get(vitima-1));
            else if (optAtk == 2) habilidadeEspecial(alvos.get(vitima-1));
            setAtacou(true);
            menuOpcoes(mapa);
            return;
        }
        else if (opcao == 3 && !atacou()) {
            System.out.println("Abrindo o inventário de " + getNome() + "...");
            System.out.println("Escolha qual item utilizar: ");
            for (Item i : inventario) {
                System.out.println("[" + (inventario.indexOf(i) + 1) + "] - " + i.getNome());
            }
            System.out.println("[ "+ (inventario.size() + 1)+"] - Voltar");
            System.out.print(">>> ");
            int itemEscolhido = scan.nextInt();

            if (itemEscolhido == inventario.size() + 1) {
                System.out.println("Certo! Voltando para menu de ações.");
                menuOpcoes(mapa);
                return;
            }
            if (itemEscolhido < 1 || itemEscolhido > inventario.size()) {
                System.out.println("Opção inválida");
                menuOpcoes(mapa);
                return;
            }
            System.out.println(usarItem(inventario.get(itemEscolhido - 1)));
            menuOpcoes(mapa);
            return;
        }
        else if (opcao == 4) {
            passarTurno();
        }
        else if (opcao == 5 && podeSurtar()) {
            System.out.println(getNome() + " acumulou muitos os pontos de surto!!");
            System.out.println(getNome() + " está SURTANDOOOO");
            ativarModoSurto();
            menuOpcoes(mapa);
            return;
        } 
        else {
            System.out.println("Essa opção ou é inválida ou já foi utilizada!");
            menuOpcoes(mapa);
            return;
        }
    }
}
