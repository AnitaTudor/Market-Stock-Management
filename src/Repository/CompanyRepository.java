package Repository;
import Model.Company;
import java.util.ArrayList;
public class CompanyRepository {

    ArrayList<Company> companies= new ArrayList<Company>();


    public void addCompany(Company company) {
    companies.add(company);

    }


    public ArrayList<Company> findCompanies() {
            return companies;

    }

    public Company findCompanyById(Integer id) {
        return companies.get(id);
    }

    public void deleteCompaniesByName(String name) {

        for(int i=0 ; i<companies.size();i++)
        {
            if(companies.get(i).getName()==name)
            {
                companies.remove(i);
            }

        }

    }

    public void updateCompany(Company company) {

        for(int i=0 ; i<companies.size();i++){
            if(companies.get(i)==company)
            {
                companies.set(i,company);

            }

        }
    }

}
