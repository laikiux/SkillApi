package com.sucy.skill.dynamic.trigger

import com.sucy.skill.facade.api.entity.Actor
import com.sucy.skill.facade.api.event.actor.ActorDamagedByActorEvent
import com.sucy.skill.util.io.Data

/**
 * SkillAPI © 2018
 */
class PhysicalTakenTrigger : BaseDamageTrigger() {
    override val requireSkillDamage = false

    /** {@inheritDoc}  */
    override val key: String
        get() = "TOOK_PHYSICAL_DAMAGE"

    /** {@inheritDoc}  */
    override fun getCaster(event: ActorDamagedByActorEvent): Actor? {
        return event.actor
    }

    /** {@inheritDoc}  */
    override fun getTarget(event: ActorDamagedByActorEvent, settings: Data): Actor? {
        return if (isUsingTarget(settings)) event.attacker else event.actor
    }
}
