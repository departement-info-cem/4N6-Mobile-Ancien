import argparse
from json import loads, dumps
import os
import sys


def read_students(file_path: str) -> list[str]:
    if not (os.path.isfile(file_path)):
        print("Le chemin vers le fichier spécifié n" "est pas valide")
        sys.exit(2)

    first_line_passed: bool = False
    students: list[str] = []

    with open(file_path) as file:
        for line in file:
            if first_line_passed:
                students.append(line[2:-3])
            else:
                first_line_passed = True
    return students


def students_to_json(students: list[str]) -> str:
    json: str = "["

    for student in students:
        json += f'{{"username" : "{student}", "password": "pass" }}'
        if student != students[-1]:
            json += ", "

    json += "]"
    
    return dumps(loads(json), sort_keys=True, indent=4, separators=(',', ': '))


def main():
    parser = argparse.ArgumentParser(
        description="Générer un fichier json à partir d"
        "une liste d"
        "étudiants produite par Omnivox"
    )
    parser.add_argument("students", type=str, help="Fichier csv produit par Omnivox")
    args = parser.parse_args()

    students = read_students(args.students)
    json_students = students_to_json(students)

    with open("output.json", "w") as json_file:
        json_file.write(json_students)
    print(json_students)

if __name__ == "__main__":
    main()
