package ast.builder

import groovy.transform.Canonical
import groovy.transform.builder.Builder

import java.time.LocalDate

@Builder
@Canonical
class Hero {
    String secretIdentity
    String name
    String company
    String job
    LocalDate hireDate
}

Hero hero = Hero
        .builder()
        .secretIdentity('Robert Parr')
        .name('Mr. Incredible')
        .company('InsuraCare')
        .job('Adjuster')
        .hireDate(LocalDate.of(2015, 4, 23))
        .build()

println hero
assert hero.name == 'Mr. Incredible'
assert hero.secretIdentity == 'Robert Parr'
assert hero.company == 'InsuraCare'
assert hero.job == 'Adjuster'

hero = Hero
        .builder()
        .secretIdentity('Helen Parr')
        .name('ElastiGirl')
        .job('Domestic Goddess')
        .hireDate(LocalDate.of(2015, 4, 23))
        .build()

println hero
assert hero.name == 'ElastiGirl'
assert hero.secretIdentity == 'Helen Parr'
