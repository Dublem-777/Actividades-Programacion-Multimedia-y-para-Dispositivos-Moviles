# Actividades · Programación Multimedia y para Dispositivos Móviles

Repositorio de ejercicios de la asignatura **Programación Multimedia y para Dispositivos Móviles**, resueltos en **Kotlin** con IntelliJ IDEA.

Los ejercicios están organizados en **15 bloques de repaso** (60 ejercicios). El índice completo, con el contenido de cada bloque, está en [`Bloques/README.md`](Bloques/README.md).

Además, la carpeta `Android/` contiene los proyectos de Android Studio (vistas XML) de la parte de **Android**, que se imparte en la asignatura Optativa.

---

## Estructura

```
.
├── README.md                    # este índice general
├── Bloques/
│   ├── README.md                # índice de los 15 bloques
│   ├── Bloque01/
│   │   └── Ejercicio1.1/        # proyecto Kotlin (src/Main.kt)
│   ├── Bloque02/
│   │   ├── Ejercicio2.1/
│   │   └── Ejercicio2.2/
│   └── …
└── Android/                     # Optativa: proyectos de Android Studio
    ├── Tema03/HelloWorld/       # recursos de cadena y de dimensión
    ├── Tema04/CountingClicks/   # Button, listener y recurso de plural
    ├── Tema08/Login/            # foco, teclado virtual, teclas IME y Toast
    └── Practicas/
        ├── Practica00_MarcoPolo/  # Práctica 0: alternar "Marco" / "Polo"
        ├── Practica01_BMI/        # Práctica 1: calculadora de BMI con clasificación
        └── Practica02_Login/      # Práctica 2: login con Snackbar y diálogo
```

Las carpetas de los bloques llevan dos cifras (`Bloque01` … `Bloque15`) para que se listen en orden. Cada carpeta `EjercicioN.M/` es un proyecto Kotlin independiente con su `src/Main.kt`, su `.iml` y su carpeta `.idea/`.

En `Android/`, cada `TemaNN/<Proyecto>/` es un proyecto de Android Studio completo (Gradle con catálogo de versiones, *wrapper* incluido, AGP 9.5, `compileSdk = 37`, `minSdk = 27`).

---

## Cómo ejecutar un ejercicio

1. Abrir la carpeta `Bloques/BloqueNN/EjercicioN.M/` como proyecto en IntelliJ IDEA.
2. Ejecutar `src/Main.kt` (botón ▶ junto a `fun main()`).

Desde terminal, con el compilador de Kotlin instalado:

```bash
kotlinc Bloques/Bloque03/Ejercicio3.4/src/*.kt -include-runtime -d /tmp/ej.jar
java -jar /tmp/ej.jar
```

### Proyectos de Android

1. Abrir la carpeta `Android/TemaNN/<Proyecto>/` en Android Studio (`File -> Open`).
2. Elegir un dispositivo (emulador o móvil) y pulsar `Run -> Run 'app'`.

Desde terminal, con el SDK en `~/Android/Sdk` y el Java de Android Studio:

```bash
cd Android/Tema08/Login
JAVA_HOME=/opt/android-studio/jbr ./gradlew assembleDebug   # genera app/build/outputs/apk/debug/app-debug.apk
```

---

## Notas

- La explicación de cada ejercicio (enunciado, conceptos, explicación paso a paso y prueba) está en las notas de Obsidian de cada bloque, fuera de este repositorio.
