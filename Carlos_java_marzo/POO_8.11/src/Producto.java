


        public class Producto{
            // atributos
            private int id;
            private String nombre;
            private double precio;

            // constructor

            public Producto(int id, String nombre, double precio) {
                this.id = id;
                this.nombre = nombre;
                this.precio = precio;
            }

            // getters

            public int getId() {
                return id;
            }

            public String getNombre() {
                return nombre;
            }

            public double getPrecio() {
                return precio;
            }

            // setters

            public void setId(int id) {
                this.id = id;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public void setPrecio(double precio) {
                this.precio = precio;
            }

            // to string
            @Override
            public String toString() {
                return "Producto{" +
                        "id=" + id +
                        ", nombre='" + nombre + '\'' +
                        ", precio=" + precio + " ";
            }
        }