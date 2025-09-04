/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

public class LibraryMember {
    private String name;
    private String memberId;

    public LibraryMember(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }

    public String getDetails() {
        return "Member: " + name + " | ID: " + memberId;
    }
}
