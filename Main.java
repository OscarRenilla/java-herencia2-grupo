import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static Map<String, Empleado> empleados = new HashMap<>();
    private static Map<String, Departamento> departamentos = new HashMap<>();
    private static Map<String, Proyecto> proyectos = new HashMap<>();
    private static GestorFichajes gestorFichajes = new GestorFichajes();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SISTEMA DE GESTIÓN Y FICHAJE ===");
            System.out.println("1. CONTRATACIÓN");
            System.out.println("2. FICHAJE");
            System.out.println("3. NÓMINAS");
            System.out.println("4. PROYECTOS (Solo desarrolladores)");
            System.out.println("5. INFORMES");
            System.out.println("6. SALIR");
            
            int op = Integer.parseInt(scanner.nextLine());
            
            switch (op) {
                case 1: menuContratacion(); break;
                case 2: menuFichaje(); break;
                case 3: menuNominas(); break;
                case 4: menuProyectos(); break;
                case 5: menuInformes(); break;
                case 6: System.exit(0);
            }
        }
    }
    
    static void menuContratacion() {
        System.out.println("1.1. Contratar empleado");
        System.out.println("1.2. Asignar a departamento");
        System.out.println("1.3. Ver contratos activos");
        int op = Integer.parseInt(scanner.nextLine());
        
        if (op == 1) {
            System.out.print("Nombre: "); String nom = scanner.nextLine();
            System.out.print("Email: "); String email = scanner.nextLine();
            System.out.print("Teléfono: "); String tel = scanner.nextLine();
            System.out.print("Fecha nacimiento (yyyy-mm-dd): "); LocalDate fn = LocalDate.parse(scanner.nextLine());
            System.out.print("Salario base: "); double sal = Double.parseDouble(scanner.nextLine());
            System.out.print("Tipo (1:Desarrollador, 2:Manager): "); int tipo = Integer.parseInt(scanner.nextLine());
            
            String id = "EMP" + (idCounter++);
            if (tipo == 1) {
                System.out.print("Nivel (Junior/Mid/Senior): "); String nivel = scanner.nextLine();
                Desarrollador d = new Desarrollador(id, nom, fn, email, tel, sal, LocalDate.now(), nivel);
                empleados.put(id, d);
            } else {
                System.out.print("Título: "); String titulo = scanner.nextLine();
                System.out.print("Presupuesto gestionado: "); double pres = Double.parseDouble(scanner.nextLine());
                Manager m = new Manager(id, nom, fn, email, tel, sal, LocalDate.now(), titulo, pres, 0);
                empleados.put(id, m);
            }
            System.out.println("Empleado " + id + " creado.");
        } 
        else if (op == 2) {
            System.out.print("ID Empleado: "); String idEmp = scanner.nextLine();
            System.out.print("Nombre Departamento: "); String depto = scanner.nextLine();
            if (!departamentos.containsKey(depto)) {
                departamentos.put(depto, new Departamento(depto, "", 0));
            }
            departamentos.get(depto).agregarEmpleado(idEmp);
            empleados.get(idEmp).setDepartamento(depto);
        } 
        else if (op == 3) {
            for (Empleado e : empleados.values()) {
                if (e.isActivo()) System.out.println(e.getIdEmpleado() + " - " + e.getNombre());
            }
        }
    }
    
    static void menuFichaje() {
        System.out.println("2.1. Registrar entrada");
        System.out.println("2.2. Registrar salida");
        System.out.println("2.3. Consultar mis fichajes");
        System.out.println("2.4. Reporte mensual de horas");
        int op = Integer.parseInt(scanner.nextLine());
        System.out.print("ID Empleado: "); String id = scanner.nextLine();
        
        if (op == 1) gestorFichajes.registrarEntrada(id);
        else if (op == 2) gestorFichajes.registrarSalida(id);
        else if (op == 3) {
            List<Fichaje> lista = gestorFichajes.obtenerFichajesDelDia(id, LocalDate.now());
            for (Fichaje f : lista) System.out.println(f.getTipo() + " " + f.getFechaHoraEntrada());
        }
        else if (op == 4) {
            System.out.print("Mes: "); int mes = Integer.parseInt(scanner.nextLine());
            System.out.print("Año: "); int anio = Integer.parseInt(scanner.nextLine());
            System.out.println("Horas: " + gestorFichajes.calcularHorasMensuales(id, mes, anio));
            System.out.println(gestorFichajes.generarReporteAsistencia(id, mes, anio));
        }
    }
    
    static void menuNominas() {
        System.out.println("3.1. Calcular salario empleado");
        System.out.println("3.2. Calcular nómina total");
        System.out.println("3.3. Ver historial de pagos");
        int op = Integer.parseInt(scanner.nextLine());
        
        if (op == 1) {
            System.out.print("ID Empleado: "); String id = scanner.nextLine();
            System.out.println("Salario: " + empleados.get(id).calcularSalario());
        } 
        else if (op == 2) {
            double total = 0;
            for (Empleado e : empleados.values()) total += e.calcularSalario();
            System.out.println("Nómina total: " + total);
        } 
        else if (op == 3) {
            System.out.println("Historial no implementado");
        }
    }
    
    static void menuProyectos() {
        System.out.println("4.1. Asignar a proyecto");
        System.out.println("4.2. Registrar horas proyecto");
        System.out.println("4.3. Ver productividad");
        int op = Integer.parseInt(scanner.nextLine());
        
        if (op == 1) {
            System.out.print("ID Proyecto: "); String idPro = scanner.nextLine();
            if (!proyectos.containsKey(idPro)) {
                System.out.print("Nombre: "); String nom = scanner.nextLine();
                System.out.print("Horas estimadas: "); double he = Double.parseDouble(scanner.nextLine());
                proyectos.put(idPro, new Proyecto(idPro, nom, he));
            }
            System.out.print("ID Desarrollador: "); String idDev = scanner.nextLine();
            proyectos.get(idPro).asignarDesarrollador(idDev);
        } 
        else if (op == 2) {
            System.out.print("ID Proyecto: "); String idPro = scanner.nextLine();
            System.out.print("ID Desarrollador: "); String idDev = scanner.nextLine();
            System.out.print("Horas: "); double h = Double.parseDouble(scanner.nextLine());
            proyectos.get(idPro).registrarHoras(idDev, h);
            if (empleados.get(idDev) instanceof Desarrollador) {
                ((Desarrollador) empleados.get(idDev)).registrarHoraExtra(h);
            }
        } 
        else if (op == 3) {
            for (Proyecto p : proyectos.values()) {
                System.out.println(p.getNombre() + ": " + p.calcularProductividad() + "%");
            }
        }
    }
    
    static void menuInformes() {
        System.out.println("5.1. Empleados por departamento");
        System.out.println("5.2. Asistencia mensual");
        System.out.println("5.3. Horas extra aprobadas");
        System.out.println("5.4. Proyectos activos");
        int op = Integer.parseInt(scanner.nextLine());
        
        if (op == 1) {
            for (Departamento d : departamentos.values()) {
                System.out.println(d.getNombre() + ": " + d.listarEmpleados());
            }
        } 
        else if (op == 2) {
            System.out.print("Mes: "); int mes = Integer.parseInt(scanner.nextLine());
            System.out.print("Año: "); int anio = Integer.parseInt(scanner.nextLine());
            for (Empleado e : empleados.values()) {
                System.out.println(e.getNombre() + ": " + gestorFichajes.calcularHorasMensuales(e.getIdEmpleado(), mes, anio) + "h");
            }
        } 
        else if (op == 3) {
            double total = 0;
            for (Empleado e : empleados.values()) {
                if (e instanceof Desarrollador) {
                    double he = ((Desarrollador) e).getHorasExtra();
                    System.out.println(e.getNombre() + ": " + he + "h");
                    total += he;
                }
            }
            System.out.println("Total horas extra: " + total);
        } 
        else if (op == 4) {
            for (Proyecto p : proyectos.values()) {
                if (p.getEstado().equals("EN_CURSO")) {
                    System.out.println(p.getNombre() + " - " + p.getIdProyecto());
                }
            }
        }
    }
}