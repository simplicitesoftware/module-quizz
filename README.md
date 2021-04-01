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
| _Ref. `qualExamexExId.qualExQuestion`_                       | _text(10000)_                            |          |           |          | -                                                                                |
| `qualExamexScore`                                            | int(100)                                 | yes      | yes       |          | -                                                                                |
| _Ref. `qualExamexExId.qualExAnswerText`_                     | _text(10000)_                            |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExType`_                           | _enum(20) using `QUALEXTYPE` list_       |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExRefenum`_                        | _enum(100) using `QUAL_REF_ENUM_CHOICES` list_ |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExAnswerType`_                     | _enum(100) using `QUALEXANWSERTYPE` list_ |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExAnswerEnumeration`_              | _char(200)_                              |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExChoicesEnumeration`_             | _text(10000)_                            |          |           |          | -                                                                                |

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
    - `Simplicité - Conception-Niveau 1-43_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-45_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-47_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-53_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-55_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-57_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-59_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-63_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-65_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-75_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-77_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-83_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-85_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-93_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-95_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-11_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-15_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-19_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-21_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-23_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-27_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-3_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-7_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-9_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-105_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-111_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-113_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-115_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-119_REF_ENUM` 
* `QUALEXANWSERTYPE`
    - `TXT` Texte
    - `ENUM` ENUM
    - `DIAG` Diagramme

`QualExercise` business object definition
-----------------------------------------

Exercise

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualExId`                                                   | char(100)                                | yes*     |           |          | -                                                                                |
| `qualExType`                                                 | enum(20) using `QUALEXTYPE` list         | yes      | yes       |          | -                                                                                |
| `qualExQuestion`                                             | text(10000)                              | yes      | yes       |          | -                                                                                |
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
    - `Simplicité - Conception-Niveau 1-43_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-45_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-47_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-53_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-55_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-57_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-59_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-63_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-65_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-75_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-77_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-83_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-85_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-93_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-95_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-11_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-15_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-19_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-21_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-23_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-27_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-3_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-7_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-9_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-105_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-111_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-113_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-115_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-119_REF_ENUM` 

`QualExUsr` business object definition
--------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      | 
| ------------------------------------------------------------ | ---------------------------------------- | -------- | --------- | -------- | -------------------------------------------------------------------------------- |
| `qualExusrUsrexamId` link to **`QualUserExam`**              | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `qualExusrUsrexamId.qualUsrexamId`_                    | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualExusrUsrexamId.qualUsrexamUsrId`_                 | _id_                                     |          |           |          | -                                                                                |
| _Ref. `qualUsrexamUsrId.usr_login`_                          | _regexp(100)_                            |          |           | yes      | _Login_                                                                          |
| _Ref. `qualExusrUsrexamId.qualUsrexamDateLimite`_            | _date_                                   |          |           |          | -                                                                                |
| _Ref. `qualExusrUsrexamId.qualUsrexamExamId`_                | _id_                                     |          |           |          | -                                                                                |
| _Ref. `qualUsrexamExamId.qualExamName`_                      | _char(100)_                              |          |           |          | -                                                                                |
| `qualExusrExamexId` link to **`QualExamEx`**                 | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `qualExusrExamexId.qualExamexExamId`_                  | _id_                                     |          |           |          | -                                                                                |
| _Ref. `qualExusrExamexId.qualExamexExId`_                    | _id_                                     |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExId`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExAnswerType`_                     | _enum(100) using `QUALEXANWSERTYPE` list_ |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExQuestion`_                       | _text(10000)_                            |          |           |          | -                                                                                |
| `qualExusrCheck`                                             | enum(100) using `QUALEXUSRCHECK` list    |          |           |          | -                                                                                |
| `qualExusrSubmitted`                                         | boolean                                  |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExRefenum`_                        | _enum(100) using `QUAL_REF_ENUM_CHOICES` list_ |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExAnswerEnumeration`_              | _char(200)_                              |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExAnswerText`_                     | _text(10000)_                            |          |           |          | -                                                                                |
| _Ref. `qualExusrExamexId.qualExamexScore`_                   | _int(100)_                               |          |           |          | -                                                                                |
| _Ref. `qualExamexExId.qualExType`_                           | _enum(20) using `QUALEXTYPE` list_       |          |           |          | -                                                                                |
| `qualExusrAnswer`                                            | text(10000)                              |          | yes       |          | -                                                                                |
| `qualExusrImage`                                             | document                                 |          | yes       |          | -                                                                                |
| `qualExusrAnswerEnumeration`                                 | enum(100) using `QUALEXUSRANSWERENUMERATION` list |          | yes       |          | -                                                                                |
| `qualExusrProgress`                                          | int(100)                                 |          |           |          | -                                                                                |

### Lists

* `QUALEXANWSERTYPE`
    - `TXT` Texte
    - `ENUM` ENUM
    - `DIAG` Diagramme
* `QUALEXUSRCHECK`
    - `OK` OK
    - `KO` KO
    - `NA` NA
* `QUAL_REF_ENUM_CHOICES`
    - `Simplicité - Conception-Niveau 1-43_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-45_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-47_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-53_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-55_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-57_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-59_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-63_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-65_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-75_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-77_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-83_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-85_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-93_REF_ENUM` 
    - `Simplicité - Conception-Niveau 1-95_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-11_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-15_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-19_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-21_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-23_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-27_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-3_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-7_REF_ENUM` 
    - `Simplicité - Notions de base-Niveau 1-9_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-105_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-111_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-113_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-115_REF_ENUM` 
    - `Simplicité - Retour Formation-Niveau 1-119_REF_ENUM` 
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
* `QUALEXUSRANSWERENUMERATION`
    - `A` code A
    - `B` code B
    - `C` code C
    - `SQL_QST_1_CHOICES_ENUM_0` code C
    - `SQL_QST_1_CHOICES_ENUM_1` code C

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
| `qualUsrToken`                                               | char(100)                                |          |           |          | -                                                                                |

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
    - `GEN` Générique

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




`QualPostTraining` external object definition
---------------------------------------------




`QualStartTestExt` external object definition
---------------------------------------------




