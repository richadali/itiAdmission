//package com.dect.itiAdmission.service;
//import com.dect.itiAdmission.domain.IVCS;
//import com.dect.itiAdmission.repository.IVCSRepository;
//import com.dect.itiAdmission.repository.VillageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class IVCSService {
//    @Autowired
//    private IVCSRepository ivcsRepository;
//
////    @Autowired
////    private IVCSSecretaryRepository ivcsSecretaryRepository;
////
////    @Autowired
////    private VillageOperatedInRepository villageOperatedInRepository;
//    @Autowired
//    private VillageRepository villageRepository;
//
////    @Transactional
////    public String saveIVCS(IVCSDTO ivcsdto){
////        VillageOperatedInList villageOperatedIn = new VillageOperatedInList();
////
////        List villageOperatedInList = ivcsdto.getVillageOperatedInList();
////        List<Villages> villagesList= new ArrayList<>();
////
////        for (int i = 0; i < villageOperatedInList.size(); i++) {
////            villagesList.add(villageRepository.getReferenceById(Long.parseLong((String) villageOperatedInList.get(i))));
////        }
////
////        villageOperatedIn.setList(villagesList);
////
////        IVCS ivcs = IVCSDTO.convertDTOToEntity(ivcsdto);
////        IVCSSecretary ivcsSecretary = IVCSDTO.convertSecretaryDTOToEntity(ivcsdto);
////
////        IVCS save = ivcsRepository.save(ivcs);
////        ivcsSecretary.setIvcs(save);
////
////        List<VillageOperatedIn> vilaageOperatedList = villageOperatedIn.getList().stream().
////                map((Villages villages) -> VillageOperatedInDTO.convertDTOToEntity(villages,save)).
////                collect(Collectors.toList());
////
////        IVCSSecretary ivcsSecretarySave =    ivcsSecretaryRepository.save(ivcsSecretary);
////        List<VillageOperatedIn> villageOperatedIns = villageOperatedInRepository.saveAll(vilaageOperatedList);
////        if (Objects.nonNull(save) && Objects.nonNull(ivcsSecretarySave) &&Objects.nonNull(villageOperatedIns)) {
////            return "success";
////        }
////        else return  "error";
////    }
//
//    public Long countIVCS(){
//        return ivcsRepository.count();
//    }
//    public List<IVCS> getAllIVCS(){
//        return ivcsRepository.findAll();
//    }
//
//
////    public List<DataEntryIVCSDTO> getIVCSDataEntry() {
////        return masterDataEntryRecordRepository.findLastUpdated();
////    }
////    public Long getTotalHhCoverage(){
////        return hhCoverageRepository.getTotalCoverage();
////    }
////    public Long getHhCoverageCount(){
////        return hhCoverageRepository.count();
////    }
////    public List<HHCoverageTempDTO> getIVCSDataEntry(){
////        return hhCoverageRepository.findLastUpdated();
////    }
//
////    @Transactional
////    public String saveIvcsDataEntry(IVCSDataEntryDTO ivcsDataEntryDTO){
////
////        Villages villages = villageRepository.getReferenceById(ivcsDataEntryDTO.getVillageId());
//////        Villages villages = villageRepository.findById(278362L).get();
////
////
////        HHCoverage hhCoverage = IVCSDataEntryDTO.convertDTOtoHHEntity(ivcsDataEntryDTO);
////        hhCoverage.setVillages(villages);
////
////        MCRepresentation mcRepresentation = IVCSDataEntryDTO.convertDTOtoMCRepresentationEntity(ivcsDataEntryDTO);
////        mcRepresentation.setVillages(villages);
////
////        ShareHoldingInIvcs shareHoldingInIvcs = IVCSDataEntryDTO.convertDTOtoShareHoldingEntity(ivcsDataEntryDTO);
////        shareHoldingInIvcs.setVillages(villages);
////
////        SavingAccount savingAccount = IVCSDataEntryDTO.convertDTOtoSavingAccountEntity(ivcsDataEntryDTO);
////        savingAccount.setVillages(villages);
////
////        FixedAccount fixedAccount = IVCSDataEntryDTO.convertDTOtoFixedAccountEntity(ivcsDataEntryDTO);
////        fixedAccount.setVillages(villages);
////
////        RecurringAccount recurringAccount = IVCSDataEntryDTO.convertDTOtoRecurringAccountEntity(ivcsDataEntryDTO);
////        recurringAccount.setVillages(villages);
////
////        LoanDisbursement loanDisbursement = IVCSDataEntryDTO.convertDTOtoLoanDisbursementEntity(ivcsDataEntryDTO);
////        loanDisbursement.setVillages(villages);
////
////        //Saving values in the Repository one by one
////        HHCoverage coverage = hhCoverageRepository.save(hhCoverage);
////        MCRepresentation representation = mCRepresentationRepository.save(mcRepresentation);
////        ShareHoldingInIvcs holdingInIvcs = shareHoldingRepository.save(shareHoldingInIvcs);
////        SavingAccount account = savingAccountRepository.save(savingAccount);
////        FixedAccount fixedAccountSaved = fixedAccountRepository.save(fixedAccount);
////        RecurringAccount recurringAccountSaved = recurringAccountRepository.save(recurringAccount);
////        LoanDisbursement disbursement = loanDisbursementRepository.save(loanDisbursement);
////        MasterDataEntryRecord masterDataEntryRecord = new MasterDataEntryRecord(coverage,representation,
////                                                            account,recurringAccountSaved,
////                                                        holdingInIvcs,fixedAccountSaved,disbursement,villages);
////
////        masterDataEntryRecordRepository.save(masterDataEntryRecord);
////
////        return "success";
////
////    }
////
////    public IVCS getByIVCSSerialNumber(String serialNumber) {
////      return   ivcsRepository.findByiVCSSerialNumber(serialNumber);
////    }
////
////    public Collection<VillageTempDTO> getIVCSOperatedIn(Long id) {
////
////        return ivcsRepository.findVillagesOparatedin(id);
////    }
////
////    public Collection<IvcsCountDistrictWise> getDistrictWiseCountIVCS(){
////        return ivcsRepository.getCountDistrictWise();
////    }
////
////    public Collection<IVCSCountBlockWise> getBLockWiseCountIVCS(){
////        return ivcsRepository.getCountBlockWise();
////    }
//
//
////    public MasterDataEntryRecord finById(Long id) {
////       return masterDataEntryRecordRepository.getReferenceById(id);
////    }
//}
