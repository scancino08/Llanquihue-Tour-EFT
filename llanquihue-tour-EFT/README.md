# 🏔️ Llanquihue Tour - Sistema de Gestión EFT

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, desarrollado en Java aplicando los principios fundamentales de la Programación Orientada a Objetos.

---

## 📋 Descripción General

El sistema permite gestionar de forma unificada distintas entidades de la agencia: clientes, guías turísticos, vehículos, paquetes turísticos y colaboradores externos. Los datos se cargan desde archivos `.txt`, se almacenan en colecciones (`ArrayList`, `HashMap`, `Stack`) y se visualizan a través de una interfaz gráfica con `JOptionPane`.

---

## 🗂️ Estructura del Proyecto

```
llanquihue-tour-s5/
├── src/
│   ├── model/               # Clases del dominio e interfaz Registrable
│   │   ├── Registrable.java          ← interfaz con mostrarResumen(), mostrarDatos(), registrar()
│   │   ├── RutInvalidoException.java ← excepción personalizada
│   │   ├── Persona.java
│   │   ├── Direccion.java
│   │   ├── Cliente.java
│   │   ├── Empleado.java
│   │   ├── GuiaTuristico.java
│   │   ├── Vehiculo.java
│   │   ├── ColaboradorExterno.java
│   │   └── PaqueteTuristico.java
│   ├── data/                # Colecciones polimórficas
│   │   └── GestorEntidades.java      ← ArrayList + HashMap + Stack + instanceof
│   ├── service/             # Carga de datos desde archivos .txt
│   │   ├── ClienteService.java
│   │   ├── GuiaService.java
│   │   ├── VehiculoService.java
│   │   └── PaqueteService.java
│   ├── util/                # Clases utilitarias
│   │   ├── LectorTXT.java
│   │   ├── LectorCSV.java
│   │   └── ValidadorRut.java
│   ├── ui/                  # Interfaz gráfica
│   │   └── VentanaPrincipal.java     ← JOptionPane
│   └── app/                 # Punto de entrada
│       └── Main.java
├── data/                    # Archivos de datos (.txt)
│   ├── clientes.txt
│   ├── guias.txt
│   ├── vehiculos.txt
│   └── paquetes.txt
└── README.md
```

---

## 🧩 Jerarquía de Clases

```
«interface» Registrable
    ├── mostrarResumen()
    ├── mostrarDatos()
    └── registrar() [default]
         ↑ implementan
    ├── Cliente            (extends Persona)
    ├── GuiaTuristico      (extends Empleado extends Persona)
    ├── Vehiculo
    ├── ColaboradorExterno
    └── PaqueteTuristico

Persona (superclase)
 ├── Cliente
 └── Empleado
      └── GuiaTuristico
```

---

## ✅ Principios POO Aplicados

| Principio | Dónde se aplica |
|---|---|
| **Encapsulamiento** | Todos los atributos son `private` con getters/setters |
| **Herencia** | `Cliente` y `Empleado` extienden `Persona`; `GuiaTuristico` extiende `Empleado` |
| **Polimorfismo** | `ArrayList<Registrable>` en `GestorEntidades`; `@Override` en todas las clases |
| **Interfaz** | `Registrable` implementada por 5 clases |
| **Composición** | `Persona` contiene un objeto `Direccion` |
| **Excepción personalizada** | `RutInvalidoException` en `ValidadorRut` |
| **Colecciones** | `ArrayList`, `HashMap`, `Stack` en `GestorEntidades` |
| **instanceof** | `listarConDetalle()` diferencia comportamiento por tipo |
| **GUI** | `VentanaPrincipal` con `JOptionPane` |
| **Archivos externos** | Carga desde `.txt` en los servicios |

---

## ▶️ Cómo Clonar y Ejecutar

```bash
git clone https://github.com/scancino08/llanquihue-tour-s8.git
```

1. Abre la carpeta en **IntelliJ IDEA** (**File → Open**)
2. Marca la carpeta `src/` como **Sources Root** (clic derecho → Mark Directory as → Sources Root)
3. Asegúrate de que la carpeta `data/` esté en la **raíz del proyecto**
4. Ejecuta la clase `app.Main`

---

## 👩‍💻 Autora

| Campo | Detalle |
|---|---|
| **Nombre** | *Soledad Cancino* |
| **Asignatura** | Desarrollo Orientado a Objetos I |
| **Institución** | Duoc UC |
