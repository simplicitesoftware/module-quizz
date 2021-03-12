<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`Qualification` module definition
=================================



`QualExam` business object definition
-------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualExamName`                                               | char(100)                                | yes*     | yes       |          | -                                                                                |
| `qualExamPublic`                                             | boolean                                  |          | yes       |          | -                                                                                |
| `qualExType`                                                 | enum(20) using `QUALEXTYPE` list         | yes      | yes       |          | -                                                                                |

### Lists

* `QUALEXTYPE`
    - `UML` UML
    - `JAVA` JAVA
    - `JS` JS
    - `SQL` SQL
    - `SIM_BASE` Simplicité - Notions de base
    - `SIM_CONCEPTION` Simplicité - Conception
    - `SIM_OPERATION` Simplicité - Opération
    - `SIM_INTEGRATION` Simplicité - Intégration
    - `SIM_REX` Simplicité - Retour Formation

`QualExamEx` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualExamexExamId` link to **`QualExam`**                    | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `qualExamexExamId.qualExamName`_                       | _char(100)_                              |          |           |          | -                                                                                |
| `qualExamexExId` link to **`QualExercise`**                  | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `qualExamexExId.qualExId`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExQuestion`_                       | _html(10000)_                            |          |           |          | -                                                                                |

`QualExercise` business object definition
-----------------------------------------

Exercise

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualExId`                                                   | char(100)                                | yes*     |           |          | -                                                                                |
| `qualExType`                                                 | enum(20) using `QUALEXTYPE` list         | yes      | yes       |          | -                                                                                |
| `qualExQuestion`                                             | html(10000)                              | yes      | yes       |          | -                                                                                |
| `qualExAnswerType`                                           | enum(100) using `QUALEXANWSERTYPE` list  | yes      | yes       |          | -                                                                                |
| `qualExAnswerText`                                           | text(10000)                              |          | yes       |          | -                                                                                |
| `qualExImage`                                                | document                                 |          | yes       |          | -                                                                                |
| `qualExDifficulty`                                           | enum(100) using `QUALEXDIFFICULTY` list  | yes      | yes       |          | -                                                                                |
| `qualExChoicesEnumeration`                                   | text(10000)                              |          | yes       |          | -                                                                                |
| `qualExAnswerEnumeration`                                    | char(200)                                |          | yes       |          | -                                                                                |
| `qualExRefenum`                                              | enum(100) using `QUAL_REF_ENUM_CHOICES` list |          | yes       |          | -                                                                                |

### Lists

* `QUALEXTYPE`
    - `UML` UML
    - `JAVA` JAVA
    - `JS` JS
    - `SQL` SQL
    - `SIM_BASE` Simplicité - Notions de base
    - `SIM_CONCEPTION` Simplicité - Conception
    - `SIM_OPERATION` Simplicité - Opération
    - `SIM_INTEGRATION` Simplicité - Intégration
    - `SIM_REX` Simplicité - Retour Formation
* `QUALEXANWSERTYPE`
    - `TXT` Texte
    - `ENUM` ENUM
    - `DIAG` Diagramme
* `QUALEXDIFFICULTY`
    - `1` Niveau 1
    - `2` Niveau 2
    - `3` Niveau 3
* `QUAL_REF_ENUM_CHOICES`
    - `Simplicité - Conception-Niveau 1-125_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-127_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-129_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-135_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-137_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-139_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-141_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-145_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-147_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-157_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-159_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-165_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-167_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-175_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-177_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-209_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-213_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-215_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-217_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-221_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-225_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-227_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-229_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-233_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-187_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-193_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-195_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-197_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-201_REF_ENUM` 

`QualExUsr` business object definition
--------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualExusrExId` link to **`QualExercise`**                   | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `qualExusrExId.qualExId`_                              | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualExusrExId.qualExQuestion`_                        | _html(10000)_                            |          |           |          | -                                                                                |
| _Ref. `qualExusrExId.qualExAnswerText`_                      | _text(10000)_                            |          |           |          | -                                                                                |
| _Ref. `qualExusrExId.qualExType`_                            | _enum(20) using `QUALEXTYPE` list_       |          |           |          | -                                                                                |
| _Ref. `qualExusrExId.qualExRefenum`_                         | _enum(100) using `QUAL_REF_ENUM_CHOICES` list_ |          |           |          | -                                                                                |
| _Ref. `qualExusrExId.qualExAnswerType`_                      | _enum(100) using `QUALEXANWSERTYPE` list_ |          |           |          | -                                                                                |
| _Ref. `qualExusrExId.qualExAnswerEnumeration`_               | _char(200)_                              |          |           |          | -                                                                                |
| `qualExusrAnswer`                                            | text(10000)                              |          | yes       |          | -                                                                                |
| `qualExusrImage`                                             | document                                 |          | yes       |          | -                                                                                |
| `qualExusrAnswerEnumeration`                                 | enum(100) using `QUALEXUSRANSWERENUMERATION` list |          | yes       |          | -                                                                                |
| `qualExusrCheck`                                             | enum(100) using `QUALEXUSRCHECK` list    |          |           |          | -                                                                                |
| `qualExusrSubmitted`                                         | boolean                                  |          |           |          | -                                                                                |
| `qualExusrProgress`                                          | int(100)                                 |          |           |          | -                                                                                |
| `qualExusrUsrexamId` link to **`QualUserExam`**              | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `qualExusrUsrexamId.qualUsrexamId`_                    | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualExusrUsrexamId.qualUsrexamUsrId`_                 | _id_                                     |          |           |          | -                                                                                |
| _Ref. `qualUsrexamUsrId.usr_login`_                          | _regexp(100)_                            |          |           | yes      | _Login_                                                                          |
| _Ref. `qualExusrUsrexamId.qualUsrexamExamId`_                | _id_                                     |          |           |          | -                                                                                |
| _Ref. `qualUsrexamExamId.qualExamName`_                      | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualExusrUsrexamId.qualUsrexamDateLimite`_            | _date_                                   |          |           |          | -                                                                                |

### Lists

* `QUALEXTYPE`
    - `UML` UML
    - `JAVA` JAVA
    - `JS` JS
    - `SQL` SQL
    - `SIM_BASE` Simplicité - Notions de base
    - `SIM_CONCEPTION` Simplicité - Conception
    - `SIM_OPERATION` Simplicité - Opération
    - `SIM_INTEGRATION` Simplicité - Intégration
    - `SIM_REX` Simplicité - Retour Formation
* `QUAL_REF_ENUM_CHOICES`
    - `Simplicité - Conception-Niveau 1-125_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-127_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-129_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-135_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-137_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-139_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-141_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-145_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-147_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-157_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-159_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-165_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-167_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-175_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-177_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-209_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-213_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-215_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-217_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-221_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-225_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-227_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-229_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-233_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-187_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-193_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-195_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-197_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-201_REF_ENUM` 
* `QUALEXANWSERTYPE`
    - `TXT` Texte
    - `ENUM` ENUM
    - `DIAG` Diagramme
* `QUALEXUSRANSWERENUMERATION`
    - `A` code A
    - `B` code B
    - `C` code C
    - `SQL_QST_1_CHOICES_ENUM_0` code C
    - `SQL_QST_1_CHOICES_ENUM_1` code C
* `QUALEXUSRCHECK`
    - `OK` OK
    - `KO` KO
    - `NA` NA

### Custom actions

* `QUAL_SUBMITANSWER`: Submit action for candidate's answers

`QualUser` business object definition
-------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualUsrTests`                                               | multi(100) using `QUALEXTYPE` list       |          | yes       |          | -                                                                                |
| `qualUsrLevel`                                               | multi(100) using `QUALEXDIFFICULTY` list |          | yes       |          | -                                                                                |
| `qualUsrTypedutilisateur`                                    | enum(100) using `QUALUSRTYPEDUTILISATEUR` list | yes      | yes       |          | -                                                                                |

### Lists

* `QUALEXTYPE`
    - `UML` UML
    - `JAVA` JAVA
    - `JS` JS
    - `SQL` SQL
    - `SIM_BASE` Simplicité - Notions de base
    - `SIM_CONCEPTION` Simplicité - Conception
    - `SIM_OPERATION` Simplicité - Opération
    - `SIM_INTEGRATION` Simplicité - Intégration
    - `SIM_REX` Simplicité - Retour Formation
* `QUALEXDIFFICULTY`
    - `1` Niveau 1
    - `2` Niveau 2
    - `3` Niveau 3
* `QUALUSRTYPEDUTILISATEUR`
    - `ADMIN` Administrateur
    - `CAND` Candidat

### Custom actions

* `QualGenerateTests`: 

`QualUserExam` business object definition
-----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualUsrexamId`                                              | char(100)                                | yes*     | yes       |          | -                                                                                |
| `qualUsrexamUsrId` link to **`QualUser`**                    | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `qualUsrexamUsrId.usr_login`_                          | _regexp(100)_                            |          |           | yes      | _Login_                                                                          |
| _Ref. `qualUsrexamUsrId.usr_last_name`_                      | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `qualUsrexamUsrId.usr_first_name`_                     | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| `qualUsrexamExamId` link to **`QualExam`**                   | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `qualUsrexamExamId.qualExamName`_                      | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualUsrexamExamId.qualExamPublic`_                    | _boolean_                                |          |           |          | -                                                                                |
| `qualUsrexamScore`                                           | int(100)                                 |          | yes       |          | -                                                                                |
| `qualUsrexamDateLimite`                                      | date                                     |          | yes       |          | -                                                                                |
| `qualUsrexamEtat`                                            | enum(100) using `QUALUSREXAMETAT` list   |          | yes       |          | -                                                                                |

### Lists

* `QUALUSREXAMETAT`
    - `TODO` À faire
    - `DONE` Terminé
    - `SCORED` Noté

`QualEndTestExt` external object definition
-------------------------------------------




`QualStartTestExt` external object definition
---------------------------------------------




