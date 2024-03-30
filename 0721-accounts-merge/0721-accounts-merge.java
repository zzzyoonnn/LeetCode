class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, String> emailToRoot = new HashMap<>();
        HashMap<String, TreeSet<String>> rootToEmails = new HashMap<>();
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                emailToRoot.put(email, email);
            }
        }
        
        for (List<String> account : accounts) {
            String root = find(account.get(1), emailToRoot);
            
            for (int i = 2; i < account.size(); i++) {
                emailToRoot.put(find(account.get(i), emailToRoot), root);
            }
        }
        
        for (String email : emailToRoot.keySet()) {
            String root = find(email, emailToRoot);
            rootToEmails.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for (String root : rootToEmails.keySet()) {
            List<String> emails = new ArrayList<>(rootToEmails.get(root));
            emails.add(0, emailToName.get(root));
            result.add(emails);
        }
        
        return result;
    }
    
    public String find(String email, Map<String, String> emailToRoot) {
        while(!emailToRoot.get(email).equals(email)) {
            email = emailToRoot.get(email);
        }
        
        return email;
    }
}