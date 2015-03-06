import java.net.*;

public class AdminFinder {
   private static String url,urlfinal,protocolo[]={"https:/"+"/", "http:/"+"/"};
   private static String[] paths = {"admin","admin.php","login","login.php","adm","adm.php","administrator","administrador","intranet","wp-admin","wp$
        public static void main(String[]args) {
                try{
                        AdminFinder i = new AdminFinder();
                        url = args[0];
                        if(args.length == 1) {
                                if(url.substring(0,4).equals("www.")) {
                                        i.banner();
                                        i.ejecutar(true);
                                }else {
                                        i.banner();
                                        i.ejecutar(false);
                                }
                        }else {
                                System.out.println("Error!!!");
                                System.out.println(" use: java AdminFinder www.webapp.com                           \n");
                                System.exit(0);
                        }
                }catch(Exception x) {
                        System.out.println("Error !!!");
                        System.out.println("use: \t java AdminFinder www.webapp.com");
                }
        }
        private void ejecutar(boolean faux) {
                System.out.println("[+] Scan URL: " +url+"\n");
                for(int i=0;i<paths.length;i++) {
                    if(faux == true) {
                        urlfinal = protocolo[0]+url+"/"+paths[i];
                    }else {
                        urlfinal = protocolo[1]+url+"/"+paths[i];
                    }
                            try {
                                URL url = new URL(urlfinal);
                                HttpURLConnection peticion = (HttpURLConnection)url.openConnection();
                                int respuesta = peticion.getResponseCode();
                                        if(respuesta == 200) {
                                                System.out.print(urlfinal);
                                                System.out.println("\t 200  -  OK");
                                        }else if(respuesta == 400) {
                                                System.out.print(urlfinal);
                                                System.out.println("\t 404  - NOT FOUND");
                                        }else if(respuesta == 500) {
                                                System.out.print(urlfinal);
                                                System.out.println("\t 500 - INTERNAL SERVER ERROR");
                                        }
                            }catch(Exception e) { 
                                System.out.println("Error de Conexion! ;) " +e);
                                System.exit(0);
                            }
                }

        }
        private void banner() {
                System.out.print("      *          *                 ******           *           \n"+
                                 "     * *         *         *       *     *          *           \n"+
                                 "    *   *        *                 *****            *           \n"+
                                 "   *******   ***** *** *** * ****  *     * **** ***** **** **** \n"+
                                 "  *       *  *   * *  *  * * *  *  *     * *  * *   * **   *    \n"+
                                 " *         * ***** *     * * *  *  *     * *  * ***** **** *    \n");
                System.out.println(" Search Logins Administrators WebApps                      v1.0 ");
                System.out.println(" Developed by @Diego_Asencio                                    ");
                System.out.println("                           @c0deTeam                          \n");
                System.out.println(" use: java AdminFinder www.webapp.com                           ");
        }
}




