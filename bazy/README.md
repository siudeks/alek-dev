1) open [db-fiddle](https://www.db-fiddle.com/)

2) insert
```SQL
-- Tworzenie tabeli Korty
CREATE TABLE Korty (
    KortId SERIAL PRIMARY KEY,
    NumerKortu VARCHAR(50) NOT NULL,
    TypKortu VARCHAR(10) CHECK (TypKortu IN ('Otwarty', 'Zamknięty')),
    CenaGodzinowa NUMERIC NOT NULL
);

-- Tworzenie tabeli Klienci
CREATE TABLE Klienci (
    KlientID SERIAL PRIMARY KEY,
    Imię VARCHAR(50) NOT NULL,
    Nazwisko VARCHAR(50) NOT NULL,
    Adres VARCHAR(200),
    Telefon VARCHAR(20),
    Email VARCHAR(50)
);

-- Tworzenie tabeli Rezerwacje
CREATE TABLE Rezerwacje (
    RezerwacjaID SERIAL PRIMARY KEY,
    KortID INT REFERENCES Korty(KortId),
    KlientID INT REFERENCES Klienci(KlientID),
    DataRozpoczęcia TIMESTAMP NOT NULL,
    DataZakończenia TIMESTAMP NOT NULL,
    Opłata NUMERIC NOT NULL,
    StatusRezerwacji VARCHAR(20) CHECK (StatusRezerwacji IN ('Aktywna', 'Anulowana', 'Zrealizowana'))
);

-- Tworzenie tabeli Pracownicy
CREATE TABLE Pracownicy (
    PracownikID SERIAL PRIMARY KEY,
    Imię VARCHAR(50) NOT NULL,
    Nazwisko VARCHAR(50) NOT NULL,
    Stanowisko VARCHAR(50)
);

-- Tworzenie tabeli ObslugaKortow
CREATE TABLE ObslugaKortow (
    MaintenanceID SERIAL PRIMARY KEY,
    KortID INT REFERENCES Korty(KortId),
    PracownikID INT REFERENCES Pracownicy(PracownikID),
    DataRaportu TIMESTAMP NOT NULL,
    OpisProblemu TEXT NOT NULL,
    Status VARCHAR(20) CHECK (Status IN ('Zgłoszone', 'Aktualne', 'Rozwiązane')),
    Koszty NUMERIC
);

-- Dodawanie przykładowych wartości do tabeli Korty
INSERT INTO Korty (NumerKortu, TypKortu, CenaGodzinowa) VALUES
('Kort1', 'Otwarty', 30.00),
('Kort2', 'Zamknięty', 40.00),
('Kort3', 'Otwarty', 25.00);

-- Dodawanie przykładowych wartości do tabeli Klienci
INSERT INTO Klienci (Imię, Nazwisko, Adres, Telefon, Email) VALUES
('Jan', 'Kowalski', 'ul. Kwiatowa 5, Warszawa', '123456789', 'jan.kowalski@example.com'),
('Anna', 'Nowak', 'ul. Słoneczna 10, Kraków', '987654321', 'anna.nowak@example.com'),
('Piotr', 'Wiśniewski', 'ul. Główna 15, Gdańsk', '555444333', 'piotr.wisniewski@example.com');

-- Dodawanie przykładowych wartości do tabeli Rezerwacje
INSERT INTO Rezerwacje (KortID, KlientID, DataRozpoczęcia, DataZakończenia, Opłata, StatusRezerwacji) VALUES
(1, 1, '2024-02-06 10:00:00', '2024-02-06 12:00:00', 60.00, 'Aktywna'),
(2, 2, '2024-02-07 14:00:00', '2024-02-07 16:00:00', 80.00, 'Zrealizowana'),
(3, 3, '2024-02-08 09:00:00', '2024-02-08 11:00:00', 50.00, 'Anulowana');

-- Dodawanie przykładowych wartości do tabeli Pracownicy
INSERT INTO Pracownicy (Imię, Nazwisko, Stanowisko) VALUES
('Adam', 'Nowak', 'Instruktor'),
('Katarzyna', 'Kowalska', 'Administrator'),
('Michał', 'Lewandowski', 'Konserwator');

-- Dodawanie przykładowych wartości do tabeli ObsługaKortow
INSERT INTO ObslugaKortow (KortID, PracownikID, DataRaportu, OpisProblemu, Status, Koszty) VALUES
(1, 3, '2024-02-05 08:00:00', 'Naprawa siatki na kortzie', 'Rozwiązane', 100.00),
(2, 1, '2024-02-06 12:00:00', 'Czyszczenie kortu', 'Aktualne', 80.00),
(3, 2, '2024-02-07 10:00:00', 'Wymiana oświetlenia', 'Zgłoszone', 200);
```