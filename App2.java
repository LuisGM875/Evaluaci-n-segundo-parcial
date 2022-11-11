import java.util.Scanner;
import java.util.Arrays;
public class App2 {

    int [] arreglo1 = new int [128]; //ARREGLOS POR JUGADORES
    int [] arreglo2 = new int[128];
    int [] arreglo3 = new int[128];
    int [] arreglo4 = new int[128];
    int [] arreglo5 = new int[128];
    int [] arreglo6 = new int[128];
    int [] arreglo7 = new int[128];
    public int ultimaCarta;
    public static void  main (String args[]){
        //LAMA A LAS DEMAS FUNCIONES A MAIN
        App2 main2= new App2(); 
        Scanner leer = new Scanner(System.in);
        int numerojugadores=0, numerobots=0;
        int numproceso;
        int terminar=0;
        while(terminar==0) {//COMIENZA MENU
            System.out.println("========JUEGO UNO=========");
            System.out.println("===Opciones para iniciar===");
            System.out.println("1 jugar con jugadores");
            System.out.println("2 salir del programa");
            numproceso = leer.nextInt();
            System.out.println("===========================");
            if (numproceso == 1) {
                System.out.println("===Ingresa jugadores==="); //INGRESAR JUGADORES
                numerojugadores = leer.nextInt();
                System.out.println("LOS TURNOS SERAN LOS JUGADORES");//TURNO ES IGUAL A JUGADOR
                int pb = 4 - numerojugadores;
                if (numerojugadores <= 4) {
                    System.out.println("==INGRESA BOTS===DE 0 A==" + 1 + "===");
                    numerobots = leer.nextInt();
                    if (numerobots <= pb) {
                        main2.numero_jugadores(numerojugadores, numerobots); //LAMA AL MAIN" PARA PROCESO
                        main2.JUEGOUNO(numerojugadores, numerobots);
                    } else {
                        System.out.println("=VALOR NO VALIDO=");
                    }
                }
            else{
                System.out.println("=INGRESE CANTIDAD CORRECTA=");
            }//TERMINA MENU DE JUGADORES
            }//CIERRA PROGRAMA
            else if (numproceso == 2) {
                System.out.println("=ADIOS=");
                terminar = 1;
            }
            else{
                System.out.println("=ELIJA UNA OPCION=");
            }
        }// TERMINA MENU DE PROCESOS
    }

    public  void numero_jugadores(int numJ, int nbot){ //ARREGLOS POR BOTS Y PERSONAS PARA BARAJAS
        int o=0;
        for(int i=0;i<128;i++){//ESPACIOS DE 128
            arreglo1[i]=-1;
            arreglo2[i]=-1;
            arreglo3[i]=-1;
            arreglo4[i]=-1;
            arreglo5[i]=-1;
            arreglo6[i]=-1;
            arreglo7[i]=-1;
        }
        for(int i=0;i<7;i++){ // ESPACIO POR PERSONA DE 7
            arreglo1[i]=dame_carta(o);
            if(numJ>=2) {
                arreglo2[i]=dame_carta(o);
                if (numJ >= 3) {
                    arreglo3[i]=dame_carta(o);
                }
                if (numJ == 4) {
                    arreglo4[i]=dame_carta(o);
                }
                if (nbot >= 1) {
                    arreglo5[i]=dame_carta(o);
                }
                if (nbot>=2) {
                    arreglo6[i]=dame_carta(o);
                }
                if (nbot>=3) {
                    arreglo7[i]=dame_carta(o);
                }}


        }

    }

    public  int dame_carta(int o) { //DA UN VALOR A LOS ARREGLOS
        //10 reversa
        //11 no juegas
        int BARAJASINCAMBIOS[]= new int[129]; // BARAJA COMPLETA
        int BARAJAAMODIFICAR[]= new int[129]; //BARAJA CAMBIANTE TRAS JUEGO
        int a;
        int value = -1;
            int t = 0;

        if(o==1){
        int x = 0;
        for (int i = 1; i < 121; i++) { //SE LLENA BARAJA SIN CAMBIOS
            BARAJASINCAMBIOS[i] = x;
            x++;
            if (x == 10) {
                x = 0;
            }
        }

        for (int i = 121; i < 125; i++) {
            BARAJASINCAMBIOS[i] = 10;
        }
        for (int i = 125; i < 129; i++) {
            BARAJASINCAMBIOS[i] = 11;
        }
        Arrays.sort(BARAJASINCAMBIOS);
        for (int i = 1; i < 129; i++) {
            BARAJAAMODIFICAR[i]=BARAJASINCAMBIOS[i]; //BARAJAS COMPARANDO POSICIONES
        }
    }

        while(t==0) {//BARAJA DE JUGADORES
            a = (int) (Math.random() * 128 + 1);
            t++;
            if (BARAJASINCAMBIOS[a] != -1) {
                value = BARAJASINCAMBIOS[a];
                BARAJASINCAMBIOS[a] = -1;
                return value;

            } else {
                t--;
            }
        }
        return value;
    }
//TERMINA DE DARLES UN NUMERO
    public void cartasInicio(int arreglo[]){ //REPARTE BARAJAS INICIALES A JUGADORES
        int o=1;
        int a;
        for(int i=0;i<7;i++){
        a=dame_carta(o);
            arreglo[i]=a;
        }
    }
//FIN DE REPARTO A LAS / CARTAS
//COMIENZA ESQUELETO DE JUEGO
    public void JUEGOUNO(int NUMJUGADORES, int NUMEROBOT){
        Scanner leer = new Scanner(System.in);
        int ganador=0;
        int turno=1;
        int o=0;
        if (o==0){
            cartasInicio(arreglo1);
            if(NUMJUGADORES>=2){
                cartasInicio(arreglo2);
                if (NUMJUGADORES >= 3){
                    cartasInicio(arreglo3);
                }
                if (NUMJUGADORES == 4){
                    cartasInicio(arreglo4);
                }
                if (NUMEROBOT >= 1){
                    cartasInicio(arreglo5);
                }
                if (NUMEROBOT>=2){
                    cartasInicio(arreglo6);
                }if (NUMEROBOT>=3){
                    cartasInicio(arreglo7);
                }
            }
        }//BOTS
        o++;
        //COMIENZA CICLO DE RONDAS
        while(ganador==0) {
            System.out.println("ronda "+o);
            if(ganador==0&&turno==1){
                System.out.println("TURNO DE "+turno);
                turno=juegoPlayer(arreglo1, turno, o);
                ganador = terminarJuego(arreglo1);
            o++;
            }
            if(ganador==0&&turno==2){
                if(NUMJUGADORES>=2){
                    System.out.println("TURNO DE " + turno);
                    turno = juegoPlayer(arreglo2,turno,o);
                    ganador = terminarJuego(arreglo2);
                }
                else{
                    turno++;
                }
            }
            if(ganador==0&&turno==3){
                if(NUMJUGADORES>=3) {
                    System.out.println("TURNO DE " + turno);
                    turno = juegoPlayer(arreglo3, turno, o);
                    ganador = terminarJuego(arreglo3);
                }
            else{
                turno++;
                }
            }
            if(ganador==0&&turno==4){
                if(NUMJUGADORES==4) {
                    System.out.println("TURNO DE " + turno);
                    turno = juegoPlayer(arreglo4, turno, o);
                    ganador = terminarJuego(arreglo4);
                }
            else{
                turno++;
                }
            }
            if(ganador==0&&turno==5) {
                if(NUMEROBOT>=1) {
                    System.out.println("TURNO DE " + turno);
                    juegoBoot(arreglo2, turno, o);
                    ganador = terminarJuego(arreglo5);
                }
            else{
                turno++;
                }
            }
            if(ganador==0&&turno==6) {
                if(NUMEROBOT>=2) {
                    System.out.println("TURNO DE " + turno);
                    juegoBoot(arreglo3, turno, o);
                    ganador = terminarJuego(arreglo6);
                }
                else{
                    turno++;
                }
                }
            if(ganador==0&&turno==7) {
                if (NUMEROBOT == 3) {
                    System.out.println("TURNO DE " + turno);
                    juegoBoot(arreglo4, turno, o);
                    ganador = terminarJuego(arreglo7);
                } else {
                    turno++;
                }
            }
            if (turno >= 8) {
                turno = 1;

            }
            }
        System.out.println("===TERMINO JUEGO===");
        }
//TERMINA CICLO DE RONDAS
    public  void imprimeCartas(int arreglo[]){
        for(int i=0;i<128;i++) {
            if (arreglo[i] != -1) {
                System.out.print(arreglo[i] + ",");
            }
        }
    }

    //regresa 0 si existe la carta, si no 1
    public  int validaExiste(int arreglo[],int carta){
        int nc=0;
        for(int i=0;i<20;i++){
            if (arreglo[i]!=-1){
                if(arreglo[i]==carta){
                    System.out.println("CARTA PUESTA");
                    arreglo[i] =-1;
                    ultimaCarta = carta;
                    return 0;
                }
            }
        }
        System.out.println("NO EXISTE ESTA CARTA");
        System.out.println("   ");
        return 1;
    }
    //PROCESO DE JUGADORES
    public int juegoPlayer(int arreglo[],int turno, int o) {
        Scanner leer = new Scanner(System.in);
        int a = 0;
        int cartaJ;
        int respVC=1;//EXISTE CARTA
        int huboCarta=0;
        turno++;
        for (int i = 0; i < 120; i++) {
            if (arreglo[i] == -1) {

            }}

        if (o == 1) {
            while (a == 0) {
                //COMIENZA A TIRAR POR JUGADOR
                while (respVC == 1) {
                    System.out.println("CARTA POR TIRAR" + ultimaCarta);
                    System.out.println("cartas del jugador");
                    imprimeCartas(arreglo);
                    System.out.println("TURNO DE ");
                    System.out.println("PON UNA CARTA");
                    cartaJ = leer.nextInt();
                        respVC = validaExiste(arreglo, cartaJ);

                            huboCarta = 1;
                    if (respVC==0) {
                            a=1;
                        }
                }
            }
        }
        else{
        while (a == 0) {
            //validar que exista
            while (respVC == 1){
                System.out.println("CARTA POR TIRAR" + ultimaCarta);
                System.out.println("cartas del jugador");
                imprimeCartas(arreglo);
                System.out.println("TURNO DE ");
                System.out.println("que carta deseas poner");
                cartaJ = leer.nextInt();
                if (cartaJ == ultimaCarta || cartaJ == ultimaCarta + 1 || cartaJ == ultimaCarta - 1 || cartaJ == 10 || cartaJ == 11) {
                    respVC = validaExiste(arreglo, cartaJ);
                    huboCarta=1;
                }
                else {
                    System.out.println("INGRESE VALOR VALIDO O CERCANO A 1 SI NO VUELVA SUBIR PARA COMER CARTA");
                    for (int i = 0; i < 120; i++) {
                        if (arreglo[i] == -1) {
                            if (a == 1) {
                                o=(int)Math.random()*9+1;
                                arreglo[i] = dame_carta(o);
                                huboCarta=1;
                                respVC=0;
                                a=0;
                                return turno;
                            }
                        }
                    }
                }
            a++;
        }

            if(huboCarta==0) {
                a=1;
                System.out.println("el jugador no tiene carta, pidiendo nueva");
                for (int i = 0; i < 120; i++) {
                    if (arreglo[i] == -1) {
                        if (a == 1) {
                            arreglo[i] = dame_carta(o);
                            huboCarta=1;
                            respVC=0;
                            a=0;
                            return turno;
                        }
                    }
                }
            }
        }
    }

        return turno;
    }
    //ARREGLO DE BOTS
    public int juegoBoot(int[] arreglo, int turno, int o){
        //validamos en sus opciones del boot

        System.out.println("=CARTAS BOOT=");
        imprimeCartas(arreglo);
        int nc=0;
        int a=1;
        int huboCarta;
        int c=0;
        for(int i=0;i<128;i++){
            if (arreglo[i]!=-1){
                if(arreglo[i]==ultimaCarta||arreglo[i]==ultimaCarta+1||arreglo[i]==ultimaCarta-1||arreglo[i]==10||arreglo[i]==11){
                    System.out.println("CARTA QUE TIRAN, TERMINARON DE JUGAR");
                    ultimaCarta = arreglo[i];
                    arreglo[i] =-1;
                    c=1;
                    i=129;
                }
            }
        }
huboCarta=c;
//SI BOT NO TIENE CARTA
        if(huboCarta==0) {
            System.out.println("=SE AGREGA CARTA NUEVA AL BOT=");
            for (int i = 0; i < 1; i++) {
                if (arreglo[i] == -1) {

                    if (a == 1) {
                        arreglo[i] = dame_carta(o);
                        huboCarta=1;
                        a=0;
                    }
                }
            }
        }
        System.out.println("FIN TURNO");
        turno++;
        return turno;
    }
    //0 es que acaba el juego y 1 es que continua
    public int terminarJuego(int[] arreglo){
        for(int i=0; i<arreglo.length; i++){
            if (arreglo[i]!=-1){
                return 0;
            }
        }
        return 1;
    }

}//TERMINA PROGRAMA :(