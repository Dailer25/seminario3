/*
package com.example.demo.Services;

import com.example.demo.DTO.*;
import com.example.demo.Entites.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Conver {
    private Patient converToPartient(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setCc(patientDTO.cc());
        patient.setName(patientDTO.name());
        patient.setLastName(patientDTO.lastName());
        patient.setGender(patientDTO.gender());
        patient.setEmail(patientDTO.email());
        patient.setPhone(patientDTO.phone());
        List<Date> dates = null;
        if (patientDTO.dates() != null) {
            dates = patientDTO.dates().stream().map(dateDTO -> {
                Date date = converToDate(dateDTO);
                date.setPatient(patient);
                return date;
            }).collect(Collectors.toList());
        }
        patient.setDates(dates);
        List<HistoricalRecord> hcs = null;
        if (patientDTO.historicalRecords() != null) {
            hcs = patientDTO.historicalRecords().stream().map(hcDTO -> {
                HistoricalRecord hc = converToHC(hcDTO);
                hc.setPatient(patient);
                return hc;
            }).collect(Collectors.toList());
        }
        patient.setHistoricalRecords(hcs);

        return patient;
    }

    private Date converToDate(DateDTO dateDTO){
        Date date = new Date();
        date.setId(dateDTO.id());
        date.setDate(dateDTO.date());
        date.setHour(dateDTO.hour());
        if (dateDTO.ccPatient() != null){
            Patient patient = new Patient();
            patient.setCc(dateDTO.ccPatient());
            date.setPatient(patient);
        }
        if (dateDTO.idDoctor() != null){
            Doctor doctor = new Doctor();
            doctor.setId(dateDTO.idDoctor());
            date.setDoctor(doctor);
        }
        if (dateDTO.idSecretariat() != null){
            Secretariat secretariat = new Secretariat();
            secretariat.setId(dateDTO.idSecretariat());
            date.setSecretariat(secretariat);
        }
        if(dateDTO.historiRecord() != null){
            HistoricalRecord hc = converToHC(dateDTO.historiRecord());
            hc.setDate(date);
            date.setHistoricalRecord(hc);
        }

        return date;
    }

    private Doctor converToDoctor(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.id());
        doctor.setCc(doctorDTO.cc());
        doctor.setName(doctorDTO.name());
        doctor.setLastName(doctorDTO.lastName());
        doctor.setEmail(doctorDTO.email());
        doctor.setPhone(doctorDTO.phone());
        List<HistoricalRecord> hcs = null;
        if (doctorDTO.historicalRecords() != null) {
            hcs = doctorDTO.historicalRecords().stream().map(hcDTO -> {;
                HistoricalRecord hc = converToHC(hcDTO);
                hc.setDoctor(doctor);
                return hc;
            }).collect(Collectors.toList());
        }
        doctor.setHistoricalRecords(hcs);
        List<Date> dates = null;
        if (doctorDTO.dates() != null) {
            dates = doctorDTO.dates().stream().map(dateDTO -> {
                Date date = converToDate(dateDTO);
                date.setDoctor(doctor);
                return date;
            }).collect(Collectors.toList());
        }
        doctor.setDates(dates);
        List<Abiality> abialities = null;
        if (doctorDTO.abialities() != null) {
            abialities = doctorDTO.abialities().stream().map(abialityDTO -> {
                Abiality abiality = converToAbiality(abialityDTO);
                abiality.setDoctor(doctor);
                return abiality;
            }).collect(Collectors.toList());
        }
        doctor.setAbialities(abialities);
        if (doctorDTO.idSpecialty() != null){
            Specialty specialty = new Specialty();
            specialty.setId(doctorDTO.idSpecialty());
            doctor.setSpecialty(specialty);
        }
        return doctor;
    }

    private HistoricalRecord converToHC(HistoricalRecordDTO hcDTO){
        HistoricalRecord hc = new HistoricalRecord();
        hc.setId(hcDTO.id());
        hc.setDiagnosis(hcDTO.diagnosis());
        hc.setDescription(hcDTO.description());
        hc.setMedical_exam(hcDTO.medical_exam());
        hc.setPrescription(hcDTO.prescription());
        if (hcDTO.ccPatient() != null){
            Patient patient = new Patient();
            patient.setCc(hcDTO.ccPatient());
            hc.setPatient(patient);
        }
        if (hcDTO.idDoctor() != null){
            Doctor doctor = new Doctor();
            doctor.setId(hcDTO.idDoctor());
            hc.setDoctor(doctor);
        }
        if(hcDTO.date() != null){
            Date date = converToDate(hcDTO.date());
            date.setHistoricalRecord(hc);
            hc.setDate(date);

        }


        return hc;
    }

    private Abiality converToAbiality(AbialtyDTO abialtyDTO){
        Abiality abiality = new Abiality();
        abiality.setId(abialtyDTO.id());
        abiality.setStart_hour(abialtyDTO.start_hour());
        abiality.setEnd_hour(abialtyDTO.end_hour());
        abiality.setState(abialtyDTO.state());
        if(abialtyDTO.idDoctor() != null){
            Doctor doctor = new Doctor();
            doctor.setId(abialtyDTO.idDoctor());
            abiality.setDoctor(doctor);
        }

        return abiality;
    }
    
    private Secretariat convertToSecretariant(SecretariatDTO secDTO){
        Secretariat sec = new Secretariat();
        sec.setId(secDTO.id());
        sec.setCc(secDTO.cc());
        sec.setName(secDTO.name());
        sec.setLastName(secDTO.lastName());
        sec.setEmail(secDTO.email());
        List<Date> dates = null;
        if (secDTO.dates() != null){
            dates = secDTO.dates().stream().map(dateDTO -> {;
                Date date = converToDate(dateDTO);
                date.setSecretariat(sec);
                return date;
            }).collect(Collectors.toList());
        }
        sec.setDates(dates);

        return sec;
    }

    private Specialty convertToSpecialty(SpecialtyDTO specialtyDTO) {
        Specialty specialty = new Specialty();
        specialty.setId(specialtyDTO.id());
        specialty.setName(specialtyDTO.name());
        List<Doctor> doctors = null;
        if (specialtyDTO.doctors() != null) {
            doctors = specialtyDTO.doctors().stream().map(doctorDTO -> {
                Doctor doctor = converToDoctor(doctorDTO);
                doctor.setSpecialty(specialty);
                return doctor;
            }).collect(Collectors.toList());
        }
        specialty.setDoctors(doctors);

        return specialty;
    }

    ////////////////////////////////////////////////////////////////////////////

    private PatientDTO convertToPatientDTO(Patient patient){

        List<DateDTO> dateDTOS = patient.getDates().stream().map(this::convertToDateDTO).collect(Collectors.toList());
        List<HistoricalRecordDTO> hcDTO = patient.getHistoricalRecords().stream().map(this::convertToHCDTO).collect(Collectors.toList());

        return new PatientDTO(
                patient.getCc(),
                patient.getName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getEmail(),
                patient.getPhone(),
                dateDTOS,
                hcDTO
        );
    }

    private DateDTO convertToDateDTO(Date date){

        PatientDTO patientDTO = convertToPatientDTO(date.getPatient());
        DoctorDTO doctorDTO = converToDoctorDTO(date.getDoctor());
        SecretariatDTO secretariatDTO = converToSecretariantDTO(date.getSecretariat());
        HistoricalRecordDTO historicalRecordDTO = date.getHistoricalRecord() != null ? convertToHCDTO(date.getHistoricalRecord()) : null;

        return new DateDTO(
                date.getId(),
                date.getDate(),
                date.getHour(),
                patientDTO.cc(),
                doctorDTO.id(),
                secretariatDTO.id(),
                historicalRecordDTO
        );
    }

    private DoctorDTO converToDoctorDTO(Doctor doctor){

        List<HistoricalRecordDTO> hcDTO = doctor.getHistoricalRecords().stream().map(this::convertToHCDTO).collect(Collectors.toList());
        List<DateDTO> dateDTOS = doctor.getDates().stream().map(this::convertToDateDTO).collect(Collectors.toList());
        List<AbialtyDTO> abialtyDTOS = doctor.getAbialities().stream().map(this::convertToAbialityDTO).collect(Collectors.toList());
        SpecialtyDTO specialtyDTO = converToSpecialtyDTO(doctor.getSpecialty());

        return new DoctorDTO(
                doctor.getId(),
                doctor.getCc(),
                doctor.getName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getPhone(),
                hcDTO,
                dateDTOS,
                abialtyDTOS,
                specialtyDTO.id()
        );
    }

    private HistoricalRecordDTO convertToHCDTO(HistoricalRecord hc){

        PatientDTO patientDTO = convertToPatientDTO(hc.getPatient());
        DoctorDTO doctorDTO = converToDoctorDTO(hc.getDoctor());
        DateDTO dateDTO = hc.getDate() != null ? convertToDateDTO(hc.getDate()) : null;

        return new HistoricalRecordDTO(
                hc.getId(),
                hc.getDiagnosis(),
                hc.getDescription(),
                hc.getMedical_exam(),
                hc.getPrescription(),
                patientDTO.cc(),
                doctorDTO.id(),
                dateDTO
        );
    }

    private AbialtyDTO convertToAbialityDTO(Abiality abiality){

        DoctorDTO doctorDTO = converToDoctorDTO(abiality.getDoctor());

        return new AbialtyDTO(
                abiality.getId(),
                abiality.getStart_hour(),
                abiality.getEnd_hour(),
                abiality.getState(),
                doctorDTO.id()
        );
    }

    private SecretariatDTO converToSecretariantDTO(Secretariat secretariat){

        List<DateDTO> dateDTOS = secretariat.getDates().stream().map(this::convertToDateDTO).collect(Collectors.toList());

        return new SecretariatDTO(
                secretariat.getId(),
                secretariat.getCc(),
                secretariat.getName(),
                secretariat.getLastName(),
                secretariat.getEmail(),
                dateDTOS
        );
    }

    private SpecialtyDTO converToSpecialtyDTO(Specialty specialty){

        Set<DoctorDTO> doctorDTOS = specialty.getDoctors().stream().map(this::converToDoctorDTO).collect(Collectors.toSet());

        return new SpecialtyDTO(
                specialty.getId(),
                specialty.getName(),
                doctorDTOS
        );
    }

}
*/
