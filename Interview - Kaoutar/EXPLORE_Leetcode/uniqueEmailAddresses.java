//https://leetcode.com/problems/unique-email-addresses/

class uniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> diffEmail = new HashSet<>();
        
        String domainName;
        String adressName;
        String[] splitString;
        
        for(String s: emails) {
            splitString = s.split("@",2);
            domainName = splitString[1];
            adressName = splitString[0];
            adressName = adressName.replace(".","");
            adressName = adressName.split("\\+")[0];
            
            diffEmail.add( adressName + "@" + domainName);
        }
        return diffEmail.size();
    }
}
