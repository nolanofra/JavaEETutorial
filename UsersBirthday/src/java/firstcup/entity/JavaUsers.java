/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstcup.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author nolanof
 */
@Entity
@NamedQuery(name="findAverageAgeDifferenceofAllUsers",
query="SELECT AVG(u.ageDifference) FROM JavaUsers u")
public class JavaUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    protected Calendar birthday;
    protected int ageDifference;
    
    public Calendar getBirthday()
    {
        return this.birthday;
    }
    
    public void setBirthday (Calendar birthday)
    {
        this.birthday = birthday;
    }
    
    public int getAgeDifference ()
    {
        return this.ageDifference;
    }
    
    public void setAgeDifference(int ageDifference)
    {
        this.ageDifference = ageDifference;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JavaUsers)) {
            return false;
        }
        JavaUsers other = (JavaUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "firstcup.entity.User[ id=" + id + " ]";
    }    
}
