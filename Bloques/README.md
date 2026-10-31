# Bloques de ejercicios de Kotlin

Ejercicios de repaso de la asignatura, agrupados en bloques. Cada ejercicio es un **proyecto de IntelliJ independiente** con su `src/Main.kt`, igual que en los temas.

La explicación de cada ejercicio (enunciado, conceptos, explicación paso a paso y prueba) está en las notas de Obsidian: `Core/DAM/Programacion_Multimedia_y_Dispositivos_Moviles/Bloques/Ejercicios Bloque N.md`.

---

## Bloques

| Bloque | Carpeta | Ejercicios | Contenido |
| --- | --- | --- | --- |
| 1 | [`Bloque1/`](Bloque1/) | 1.1 | Media de notas, mayor y menor (`readln`, plantillas) |
| 2 | [`Bloque2/`](Bloque2/) | 2.1 – 2.2 | Ordenar 3 números con `if` · mayúscula/minúscula por código |
| 3 | [`Bloque3/`](Bloque3/) | 3.1 – 3.6 | Arrays · `Any?` · primos · bisiestos · argumentos por defecto y con nombre |
| 4 | [`Bloque4/`](Bloque4/) | 4.1 – 4.5 | `vararg` · `infix` · `when` anidado, sin sujeto y con sujeto |
| 5 | [`Bloque5/`](Bloque5/) | 5.1 – 5.3 | `when` sobre `Any?` con guardas · árbol de Navidad con `for` y `repeat` |
| 6 | [`Bloque6/`](Bloque6/) | 6.1 – 6.3 | Llamada segura `?.` · Elvis `?:` · cast seguro `as?` |
| 7 | [`Bloque7/`](Bloque7/) | 7.1 – 7.3 | `init` y `require` · constructor secundario · setter con validación |
| 8 | [`Bloque8/`](Bloque8/) | 8.1 – 8.5 | Propiedad de respaldo · herencia · `inner` · `object` · `companion object` |
| 9 | [`Bloque9/`](Bloque9/) | 9.1 – 9.3 | `data class` y `copy()` · desestructuración · clase abstracta |
| 10 | [`Bloque10/`](Bloque10/) | 10.1 – 10.3 | Enum con propiedades · interfaces · *object expressions* |
| 11 | [`Bloque11/`](Bloque11/) | 11.1 – 11.3 | `const val` · *extension function* · *extension property* |
| 12 | [`Bloque12/`](Bloque12/) | 12.1 – 12.5 | *Top-level* y `private` · `lateinit` · orden superior · `filter`/`map` |
| 13 | [`Bloque13/`](Bloque13/) | 13.1 – 13.3 | Sobrecarga de `+` · `by lazy` · singleton perezoso |
| 14 | [`Bloque14/`](Bloque14/) | 14.1 – 14.9 | *Sealed* · *value class* · `fun interface` · `inline` · genéricos · funciones con receptor |
| 15 | [`Bloque15/`](Bloque15/) | 15.1 – 15.6 | Colecciones · operadores · métodos de listas · secuencias |

El ejercicio **12.1** tiene dos ficheros (`src/StringUtils.kt` y `src/Main.kt`), porque trata la visibilidad `private` entre ficheros.

---

## Estructura

```
Bloques/
├── README.md
├── Bloque1/
│   └── Ejercicio1.1/
│       ├── Ejercicio1.1.iml
│       ├── .idea/
│       └── src/Main.kt
├── Bloque2/
│   ├── Ejercicio2.1/
│   └── Ejercicio2.2/
└── …
```

## Cómo ejecutar un ejercicio

1. En IntelliJ IDEA: **File → Open** y elegir la carpeta `BloqueN/EjercicioN.M/`.
2. Ejecutar `src/Main.kt` con el botón ▶ junto a `fun main()`.

Desde terminal:

```bash
kotlinc Bloques/Bloque3/Ejercicio3.4/src/*.kt -include-runtime -d /tmp/ej.jar
java -jar /tmp/ej.jar
```

Se usa `src/*.kt` para que también funcione con el ejercicio 12.1, que tiene dos ficheros.
