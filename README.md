# Actividades · Programación Multimedia y para Dispositivos Móviles

Repositorio de ejercicios de la asignatura **Programación Multimedia y para Dispositivos Móviles**, resueltos en **Kotlin** con IntelliJ IDEA.

Los ejercicios están organizados en **15 bloques de repaso** (60 ejercicios). El índice completo, con el contenido de cada bloque, está en [`Bloques/README.md`](Bloques/README.md).

---

## Estructura

```
.
├── README.md                    # este índice general
└── Bloques/
    ├── README.md                # índice de los 15 bloques
    ├── Bloque01/
    │   └── Ejercicio1.1/        # proyecto Kotlin (src/Main.kt)
    ├── Bloque02/
    │   ├── Ejercicio2.1/
    │   └── Ejercicio2.2/
    └── …
```

Las carpetas de los bloques llevan dos cifras (`Bloque01` … `Bloque15`) para que se listen en orden. Cada carpeta `EjercicioN.M/` es un proyecto Kotlin independiente con su `src/Main.kt`, su `.iml` y su carpeta `.idea/`.

---

## Cómo ejecutar un ejercicio

1. Abrir la carpeta `Bloques/BloqueNN/EjercicioN.M/` como proyecto en IntelliJ IDEA.
2. Ejecutar `src/Main.kt` (botón ▶ junto a `fun main()`).

Desde terminal, con el compilador de Kotlin instalado:

```bash
kotlinc Bloques/Bloque03/Ejercicio3.4/src/*.kt -include-runtime -d /tmp/ej.jar
java -jar /tmp/ej.jar
```

---

## Notas

- La explicación de cada ejercicio (enunciado, conceptos, explicación paso a paso y prueba) está en las notas de Obsidian de cada bloque, fuera de este repositorio.
