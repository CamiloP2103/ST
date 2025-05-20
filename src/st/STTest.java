package ST;

/**
 * Clase de prueba para la tabla de símbolos no ordenada con nodos enlazados (ST)
 */
public class STTest {
    
    public static void main(String[] args) {
        // Prueba con String y Integer
        testStringInteger();
        
        // Prueba con Integer y String
        testIntegerString();
        
        // Prueba de operaciones avanzadas
        testAdvancedOperations();
        
        System.out.println("¡Todas las pruebas completadas exitosamente!");
    }
    
    private static void testStringInteger() {
        System.out.println("\n=== PRUEBA CON STRING Y INTEGER ===");
        ST<String, Integer> st = new ST<>();
        
        // Verificar que la tabla comienza vacía
        System.out.println("Inicialmente vacía: " + st.isEmpty());
        System.out.println("Tamaño inicial: " + st.size());
        
        // Insertar elementos
        System.out.println("\nInsertando elementos...");
        st.put("uno", 1);
        st.put("dos", 2);
        st.put("tres", 3);
        
        // Verificar tamaño y estado
        System.out.println("¿Vacía después de inserciones?: " + st.isEmpty());
        System.out.println("Tamaño después de inserciones: " + st.size());
        
        // Verificar get
        System.out.println("\nVerificando valores...");
        System.out.println("st.get(\"uno\"): " + st.get("uno"));
        System.out.println("st.get(\"dos\"): " + st.get("dos"));
        System.out.println("st.get(\"tres\"): " + st.get("tres"));
        System.out.println("st.get(\"cuatro\"): " + st.get("cuatro")); // Debería ser null
        
        // Verificar contains
        System.out.println("\nVerificando contains...");
        System.out.println("st.contains(\"uno\"): " + st.contains("uno"));
        System.out.println("st.contains(\"cuatro\"): " + st.contains("cuatro"));
        
        // Modificar un valor
        System.out.println("\nModificando un valor...");
        st.put("uno", 100);
        System.out.println("st.get(\"uno\") después de modificación: " + st.get("uno"));
        
        // Iterar sobre las claves
        System.out.println("\nIterando sobre las claves...");
        for (String key : st) {
            System.out.println("Clave: \"" + key + "\" → Valor: " + st.get(key));
        }
        
        // Eliminar un elemento
        System.out.println("\nEliminando elemento \"dos\"...");
        st.delete("dos");
        System.out.println("Tamaño después de eliminar: " + st.size());
        System.out.println("st.contains(\"dos\") después de eliminar: " + st.contains("dos"));
        
        // Iterar después de eliminar
        System.out.println("\nIterando después de eliminar...");
        for (String key : st) {
            System.out.println("Clave: \"" + key + "\" → Valor: " + st.get(key));
        }
    }
    
    private static void testIntegerString() {
        System.out.println("\n=== PRUEBA CON INTEGER Y STRING ===");
        ST<Integer, String> st = new ST<>();
        
        // Verificar que la tabla comienza vacía
        System.out.println("Inicialmente vacía: " + st.isEmpty());
        
        // Insertar elementos
        System.out.println("\nInsertando elementos...");
        st.put(1, "uno");
        st.put(2, "dos");
        st.put(3, "tres");
        
        // Verificar tamaño
        System.out.println("Tamaño después de inserciones: " + st.size());
        
        // Verificar get
        System.out.println("\nVerificando valores...");
        System.out.println("st.get(1): " + st.get(1));
        System.out.println("st.get(2): " + st.get(2));
        System.out.println("st.get(3): " + st.get(3));
        
        // Iterar sobre las claves
        System.out.println("\nIterando sobre las claves...");
        for (Integer key : st) {
            System.out.println("Clave: " + key + " → Valor: \"" + st.get(key) + "\"");
        }
    }
    
    private static void testAdvancedOperations() {
        System.out.println("\n=== PRUEBA DE OPERACIONES AVANZADAS ===");
        ST<String, Integer> st = new ST<>();
        
        // Llenar la tabla
        String[] palabras = {"hola", "mundo", "java", "estructura", "datos", "tabla", "simbolos"};
        
        System.out.println("Insertando palabras con índice como valor...");
        for (int i = 0; i < palabras.length; i++) {
            st.put(palabras[i], i);
        }
        
        System.out.println("Tamaño después de inserciones: " + st.size());
        
        // Verificar el orden de iteración (debería ser inverso al de inserción debido a la implementación)
        System.out.println("\nVerificando orden de iteración...");
        System.out.println("Nota: El orden debería ser inverso al de inserción (LIFO)");
        for (String key : st) {
            System.out.println("Clave: \"" + key + "\" → Valor: " + st.get(key));
        }
        
        // Probar la funcionalidad de actualización
        System.out.println("\nActualizando valores...");
        for (String palabra : palabras) {
            Integer valorAnterior = st.get(palabra);
            st.put(palabra, valorAnterior * 10);
        }
        
        System.out.println("Valores después de actualización:");
        for (String key : st) {
            System.out.println("Clave: \"" + key + "\" → Valor: " + st.get(key));
        }
        
        // Prueba de eliminación múltiple
        System.out.println("\nEliminando múltiples elementos...");
        
        // Eliminar primero, medio y último elemento basado en el orden de inserción
        st.delete("simbolos"); // último insertado (primero en la lista)
        st.delete("estructura"); // medio
        st.delete("hola"); // primero insertado (último en la lista)
        
        System.out.println("Tamaño después de eliminar 3 elementos: " + st.size());
        System.out.println("Elementos restantes:");
        for (String key : st) {
            System.out.println("Clave: \"" + key + "\" → Valor: " + st.get(key));
        }
    }
}