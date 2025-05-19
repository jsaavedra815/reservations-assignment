
# Sistema de Gestión Académica

Este proyecto es una API REST creada con **Kotlin**, **Spring Boot**, **Gradle** y **H2** como base de datos en memoria. Permite gestionar profesores, estudiantes y asignaturas, incluyendo la inscripción de estudiantes en asignaturas específicas.

---

## 📌 Funcionalidades principales

- Crear profesores
- Crear estudiantes
- Crear asignaturas asignadas a un profesor
- Inscribir estudiantes en asignaturas
- Listar profesores, estudiantes y asignaturas
- Consultar asignaturas junto con sus estudiantes y profesor responsable

---

## 🚀 Requisitos

- Java 17 o superior
- IntelliJ IDEA (opcional)
- Gradle
- Postman o cURL para pruebas

---

## 🛠️ Cómo ejecutar

1. Clona el repositorio
2. Abre el proyecto en IntelliJ o tu IDE favorito
3. Asegúrate de tener configurado Java 17+
4. Ejecuta la clase `Application.kt`
5. La API estará disponible en `http://localhost:8080`

---

## 🔧 Endpoints disponibles

### Profesores
- `POST /api/professors` → crear profesor
- `GET /api/professors` → listar todos

### Estudiantes
- `POST /api/students` → crear estudiante
- `GET /api/students` → listar todos

### Asignaturas
- `POST /api/subjects` → crear asignatura (`professorId` requerido)
- `GET /api/subjects` → listar todas
- `POST /api/subjects/{subjectId}/enroll/{studentId}` → inscribir estudiante

---

## 🧱 Estructura de entidades

- **Professor**
    - `id: Long`
    - `name: String`
    - `department: String`

- **Student**
    - `id: Long`
    - `name: String`
    - `email: String`

- **Subject**
    - `id: Long`
    - `name: String`
    - `semester: String`
    - `professor: Professor`
    - `students: List<Student>`

---

## 🗃️ Consultas SQL útiles

Puedes usarlas en la consola H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Ver todas las entidades

```sql
SELECT * FROM PROFESSORS;
SELECT * FROM STUDENTS;
SELECT * FROM SUBJECTS;
SELECT * FROM SUBJECT_STUDENTS;
```

### Ver estudiantes de una asignatura (ID = 1)

```sql
SELECT 
    sj.name AS subject_name,
    pr.name AS professor_name,
    st.name AS student_name,
    st.email AS student_email
FROM SUBJECTS sj
INNER JOIN PROFESSORS pr ON sj.professor_id = pr.id
INNER JOIN SUBJECT_STUDENTS ss ON sj.id = ss.subject_id
INNER JOIN STUDENTS st ON ss.student_id = st.id
WHERE sj.id = 1;
```

### Ver estudiantes de una asignatura (ID = 2)

```sql
SELECT 
    sj.name AS subject_name,
    pr.name AS professor_name,
    st.name AS student_name,
    st.email AS student_email
FROM SUBJECTS sj
INNER JOIN PROFESSORS pr ON sj.professor_id = pr.id
INNER JOIN SUBJECT_STUDENTS ss ON sj.id = ss.subject_id
INNER JOIN STUDENTS st ON ss.student_id = st.id
WHERE sj.id = 2;
```

---

## 🧪 Pruebas rápidas con cURL

### Crear profesor
```bash
curl -X POST http://localhost:8080/api/professors   -H "Content-Type: application/json"   -d '{ "name": "Jorge Saavedra", "department": "Software" }'
```

### Crear estudiante
```bash
curl -X POST http://localhost:8080/api/students   -H "Content-Type: application/json"   -d '{ "name": "Sofía Torres", "email": "sofia@puce.edu.ec" }'
```

### Crear asignatura
```bash
curl -X POST http://localhost:8080/api/subjects   -H "Content-Type: application/json"   -d '{ "name": "Arquitectura Empresarial", "semester": "2025A", "professorId": 1 }'
```

### Inscribir estudiante
```bash
curl -X POST http://localhost:8080/api/subjects/1/enroll/1
```

---

## 🧠 Notas

- El proyecto utiliza `@ControllerAdvice` para manejo centralizado de errores.
- Se implementaron `Mapper` y `DTOs` para separar entidades de persistencia de las respuestas.

---

## 📎 Licencia

Uso académico para PUCE TEC.
