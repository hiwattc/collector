package com.staroot.collector;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



//@Audited
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends CreatedAuditing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    private String name;

    private int listOrder;

    @Enumerated(EnumType.STRING)
    private PriorityType priorityType;

    @Embedded
    @AttributeOverrides({
            //@AttributeOverride(name = "ipAddress", column = @Column(name = "ip")),
    })
    private IPAddress ipAddress;

//    @OrderBy("listOrder asc")
    @OneToMany(mappedBy = "parent")
    private List<Menu> children = new ArrayList<>();

//    @Audited(targetAuditMode = NOT_AUDITED)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public Menu(final String name, final Users user, final String ipAddress, final Menu parent, final PriorityType priorityType) {
        this.name = name;
        this.user = user;
        this.ipAddress = IPAddress.from(ipAddress);
        this.parent = parent;
        this.priorityType = priorityType;
    }

}
